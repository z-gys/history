package ru.mobiledimension.edu.history;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class InjectByTypeObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Field[] fileds = t.getClass().getDeclaredFields();
        for (Field field: fileds) {
            if (field.isAnnotationPresent(InjectByType.class)){
                Object object = ObjectFactory.getInstance().createObject(field.getType());
                field.setAccessible(true);
                field.set(t, object);
            }
        }
    }
}
