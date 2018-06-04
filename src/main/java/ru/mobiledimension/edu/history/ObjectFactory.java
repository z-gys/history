package ru.mobiledimension.edu.history;

import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private Reflections scanner = new Reflections("ru.mobiledimension.edu.history");

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
    public <T> T createObject(Class<T> clazz) {
        T instance = clazz.newInstance();
        for (ObjectConfigurator configurator: configurators) {
            configurator.configure(instance);
        }
        return instance;
    }
}
