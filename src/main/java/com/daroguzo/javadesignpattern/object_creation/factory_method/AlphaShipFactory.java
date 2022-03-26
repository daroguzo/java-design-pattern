package com.daroguzo.javadesignpattern.object_creation.factory_method;

public class AlphaShipFactory implements ShipFactory{

    @Override
    public Ship createShip() {
        return new AlphaShip();
    }
}
