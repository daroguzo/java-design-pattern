package com.daroguzo.javadesignpattern.object_creation.abstract_factory;

import com.daroguzo.javadesignpattern.object_creation.factory_method.Ship;
import com.daroguzo.javadesignpattern.object_creation.factory_method.ShipFactory;

public class ShipInventory {
    public static void main(String[] args) {
        ShipFactory shipFactory = new AlphaShipFactory(new AlphaPartsProFactory());

        Ship ship = shipFactory.createShip();
        System.out.println(ship.getAnchor().getClass());
        System.out.println(ship.getWheel().getClass());
    }
}
