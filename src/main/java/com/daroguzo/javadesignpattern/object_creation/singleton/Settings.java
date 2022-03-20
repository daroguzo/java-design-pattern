package com.daroguzo.javadesignpattern.object_creation.singleton;

public class Settings {

    private static volatile Settings instance;

    private Settings() {}

    public static Settings getInstance() {
        if (instance == null) {
            synchronized (Settings.class) {
                if (instance == null) {
                    instance = new Settings();
                }
            }
        }

        return instance;
    }

}
