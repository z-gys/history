package ru.mobiledimension.edu.history;

/**
 * @author U.Goryntsev 03.06.2018.
 */
public class IRobot {
    private Cleaner cleaner = ObjectFactory.getInstance().createCleaner();
    private Speaker speaker = ObjectFactory.getInstance().createSpeaker();

    public void cleanTheRoom() {
        speaker.speak("Начинаю убирать");
        cleaner.clean();
        speaker.speak("Я все");
    }
}
