package com.daroguzo.javadesignpattern.object_creation.singleton;

public class Settings {

    private Settings() {}

    private static final class InstanceHolder {
        private static final Settings instance = new Settings();
    }

    public static Settings getInstance() {

        return InstanceHolder.instance;
    }

}
