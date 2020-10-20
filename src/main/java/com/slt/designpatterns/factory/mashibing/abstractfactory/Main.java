package com.slt.designpatterns.factory.mashibing.abstractfactory;

/**
 * 产品族
 * ModernFactory
 * MagicFactory
 */
public class Main {
    public static void main(String[] args) {
        AbastractFactory f = new ModernFactory();
        Vehicle c = f.createVehicle();
        c.go();
        Weapon w = f.createWeapon();
        w.shoot();
        Food b = f.createFood();
        b.printName();


        AbastractFactory f2 = new MagicFactory();
        Vehicle c2 = f2.createVehicle();
        c2.go();
        Weapon w2 = f2.createWeapon();
        w2.shoot();
        Food b2 = f2.createFood();
        b2.printName();
    }
}
