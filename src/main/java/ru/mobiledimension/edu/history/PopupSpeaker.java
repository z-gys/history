package ru.mobiledimension.edu.history;

import javax.swing.*;

public class PopupSpeaker implements Speaker {
    @Override
    public void speak(String phrase) {
        JOptionPane.showMessageDialog(null, phrase);
    }
}
