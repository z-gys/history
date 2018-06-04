package ru.mobiledimension.edu.history;

/**
 * @author U.Goryntsev 03.06.2018.
 */
public class IRobot {
    private Cleaner cleaner = ObjectFactory.getInstance().createObject(Cleaner.class);
    private Speaker speaker = ObjectFactory.getInstance().createObject(Speaker.class);

    public void cleanTheRoom() {
        speaker.speak("Начинаю убирать");
        cleaner.clean();
        speaker.speak("Я все");
    }
}
