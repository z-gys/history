package ru.mobiledimension.edu.history;

import lombok.SneakyThrows;

/**
 * @author U.Goryntsev 03.06.2018.
 */
public class CleanerImpl implements Cleaner {

    @Override
    @SneakyThrows
    public void clean() {
        System.out.println("VVVVVVVVVVvvvvvvvvvVVVVVVVVVVVVV");
        Thread.sleep(500);
    }
}
