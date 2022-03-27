package com.daroguzo.javadesignpattern.object_creation.abstract_factory;

import com.daroguzo.javadesignpattern.object_creation.factory_method.AlphaShip;
import com.daroguzo.javadesignpattern.object_creation.factory_method.Ship;
import com.daroguzo.javadesignpattern.object_creation.factory_method.ShipFactory;

public class AlphaShipFactory implements ShipFactory {

    private ShipPartsFactory shipPartsFactory;

    public AlphaShipFactory(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }

    @Override
    public Ship createShip() {
        AlphaShip alphaShip = new AlphaShip();
        alphaShip.setAnchor(shipPartsFactory.createAnchor());
        alphaShip.setWheel(shipPartsFactory.createWheel());
        return alphaShip;
    }
}
