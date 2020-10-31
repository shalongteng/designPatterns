package com.slt.designpatterns.factory.mashibing;

/**
 * 扫帚
 */
public class Broom implements Moveable{

    @Override
    public void go() {
        System.out.println("broom flying chuachuachua .....");
    }
}
