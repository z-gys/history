package ru.mobiledimension.edu.history;

/**
 * @author U.Goryntsev 03.06.2018.
 */
public class Speaker {

    @InjectRandomName
    private String name;

    public String getName() {
        return name;
    }

    public Speaker setName(String name) {
        this.name = name;
        return this;
    }

    public void speak(String phrase) {
        System.out.println(name + ": " + phrase);
    }
}
