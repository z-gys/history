package ru.mobiledimension.edu.history;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private Reflections scanner = new Reflections("ru.mobiledimension.edu.history");
    private Config config = new JavaConfig();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurator>> classes = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> aClass: classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                configurators.add(aClass.newInstance());
            }
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> aClass = resolveImpl(type);

        T t = aClass.newInstance();
        configure(t);
        invokeInitMethods(t);

        if (aClass.isAnnotationPresent(Benchmark.class)) {
            return (T) Proxy.newProxyInstance(type.getClassLoader(), aClass.getInterfaces(), (proxy, method, args) -> {
                System.out.println("********BENCHMARK************");
                System.out.println(method.getName()+" started");
                long start = System.nanoTime();
                Object retVal = method.invoke(t, args);
                long end = System.nanoTime();
                System.out.println(method.getName()+" ended in " + (end-start));
                System.out.println("********BENCHMARK************");
                return retVal;
            });
        }

        return t;
    }

    private <T> void invokeInitMethods(T instance) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = instance.getClass().getDeclaredMethods();
        for (Method method: methods) {
            if (method.isAnnotationPresent(InitMethod.class)) {
                method.invoke(instance);
            }
        }
    }

    private <T> void configure(T instance) {
        for (ObjectConfigurator configurator: configurators) {
            configurator.configure(instance);
        }
    }

    public <T> Class<? extends T> resolveImpl(Class<T> type) {
        if (!type.isInterface()) {
            return type;
        }

        Class<T> implClass = config.getImplClass(type);
        if (implClass != null) {
            return implClass;
        }

        Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
        if (classes.size() !=1) {
            throw new RuntimeException("0 or more than one impl found for " + type + "! Check your config");
        }
        return classes.stream().findAny().get();
    }
}
