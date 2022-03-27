package com.daroguzo.javadesignpattern.object_creation.abstract_factory;

public interface ShipPartsFactory {

    Anchor createAnchor();

    Wheel createWheel();
}
