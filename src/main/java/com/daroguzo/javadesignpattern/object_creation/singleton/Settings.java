package com.daroguzo.javadesignpattern.object_creation.singleton;

import java.io.Serializable;

public class Settings implements Serializable {

    private Settings() {}

    private static final class InstanceHolder {
        private static final Settings instance = new Settings();
    }

    public static Settings getInstance() {

        return InstanceHolder.instance;
    }

    protected Object readResolve() {
        return getInstance();
    }

}
