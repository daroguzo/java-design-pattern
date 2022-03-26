package com.daroguzo.javadesignpattern.object_creation.factory_method;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();

        Ship alphaShip = new AlphaShipFactory().orderShip("alphaShip", "daroguzo@mail.com");
        System.out.println(alphaShip);

        Ship betaShip = new BetaShipFactory().orderShip("betaShip", "keesun@mail.com");
        System.out.println(betaShip);
    }
}
