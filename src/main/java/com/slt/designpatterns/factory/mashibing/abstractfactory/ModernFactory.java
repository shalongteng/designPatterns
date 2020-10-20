package com.slt.designpatterns.factory.mashibing.abstractfactory;

/**
 * 现代人一族
 */
public class ModernFactory extends AbastractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
