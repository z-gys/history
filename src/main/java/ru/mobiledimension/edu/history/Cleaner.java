package ru.mobiledimension.edu.history;

import lombok.SneakyThrows;

public interface Cleaner {
    @SneakyThrows
    void clean();

    void init();
}
