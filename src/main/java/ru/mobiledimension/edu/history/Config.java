package ru.mobiledimension.edu.history;

public interface Config {
    <T> Class<T> getImplClass(Class<T> type);
}
