package com.daroguzo.javadesignpattern.object_creation.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Settings settings1 = Settings.getInstance();

        Constructor<Settings>constructor = Settings.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Settings settings2 = constructor.newInstance();

        System.out.println(settings1.equals(settings2));

    }
}