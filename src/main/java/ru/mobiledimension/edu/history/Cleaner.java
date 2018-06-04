package ru.mobiledimension.edu.history;

import lombok.SneakyThrows;

@Benchmark
public interface Cleaner {
    @SneakyThrows
    void clean();

    void init();
}
