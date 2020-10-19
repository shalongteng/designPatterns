package com.slt.designpatterns.factory.factory1.abstractFactory;

public class M4A1_Factory implements Factory{

    @Override
    public Gun produceGun() {
        return new M4A1();
    }

    @Override
    public Bullet produceBullet() {
        return new M4A1_Bullet();
    }

}

