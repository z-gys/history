package ru.mobiledimension.edu.history;

/**
 * @author U.Goryntsev 03.06.2018.
 */
public class Speaker {
    private String name;

    public Speaker(String name) {
        this.name = name;
    }

    public void speak(String phrase) {
        System.out.println(name + ": " + phrase);
    }
}
