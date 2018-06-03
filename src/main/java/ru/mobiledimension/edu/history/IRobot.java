package ru.mobiledimension.edu.history;

/**
 * @author U.Goryntsev 03.06.2018.
 */
public class IRobot {
    private Cleaner cleaner = new Cleaner();
    private Speaker speaker = new Speaker("Marfa");

    public void cleanTheRoom() {
        speaker.speak("Начинаю убирать");
        cleaner.clean();
        speaker.speak("Я все");
    }
}
