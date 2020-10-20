package com.slt.designpatterns.factory.mashibing.abstractfactory;

/**
 * 产品族
 * 魔法一族
 */
public class MagicFactory extends AbastractFactory {
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
