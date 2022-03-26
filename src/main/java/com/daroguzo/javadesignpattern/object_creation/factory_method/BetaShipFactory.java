package com.daroguzo.javadesignpattern.object_creation.factory_method;

public class BetaShipFactory implements ShipFactory{

    @Override
    public Ship createShip() {
        return new BetaShip();
    }
}
