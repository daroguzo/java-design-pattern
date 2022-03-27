package com.daroguzo.javadesignpattern.object_creation.abstract_factory;

public class AlphaPartsProFactory implements ShipPartsFactory{
    @Override
    public Anchor createAnchor() {
        return new AlphaAnchorPro();
    }

    @Override
    public Wheel createWheel() {
        return new AlphaWheelPro();
    }
}
