package ru.mobiledimension.edu.history;

import org.fluttercode.datafactory.impl.DataFactory;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private static DataFactory dataFactory = new DataFactory();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
    }

    public Cleaner createCleaner() {
        return new Cleaner();
    }

    public Speaker createSpeaker() {
        Speaker speaker = new Speaker();
        speaker.setName(dataFactory.getName());
        return speaker;
    }

    public IRobot createIRobot() {
        return new IRobot();
    }
}
