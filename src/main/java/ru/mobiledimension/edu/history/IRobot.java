package ru.mobiledimension.edu.history;

/**
 * @author U.Goryntsev 03.06.2018.
 */
public class IRobot {
    @InjectByType
    private Cleaner cleaner;
    @InjectByType
    private Speaker speaker;

    public void cleanTheRoom() {
        speaker.speak("Начинаю убирать");
        cleaner.clean();
        speaker.speak("Я все");
    }
}
