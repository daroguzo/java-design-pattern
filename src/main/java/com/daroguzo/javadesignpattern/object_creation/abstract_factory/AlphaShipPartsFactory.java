package com.daroguzo.javadesignpattern.object_creation.abstract_factory;

public class AlphaShipPartsFactory implements ShipPartsFactory{
    @Override
    public Anchor createAnchor() {
        return new AlphaAnchor();
    }

    @Override
    public Wheel createWheel() {
        return new AlphaWheel();
    }
}
