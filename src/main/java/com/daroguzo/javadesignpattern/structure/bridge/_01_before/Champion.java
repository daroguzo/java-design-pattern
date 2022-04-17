package com.daroguzo.javadesignpattern.structure.bridge._01_before;

import com.daroguzo.javadesignpattern.structure.bridge._02_after.Skin;

public interface Champion extends Skin {

    void move();

    void skillQ();

    void skillW();

    void skillE();

    void skillR();

}
