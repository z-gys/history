package ru.mobiledimension.edu.history;

/**
 * @author U.Goryntsev 04.06.2018.
 */
public class Main {
    public static void main(String[] args) {
        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanTheRoom();
    }
}
