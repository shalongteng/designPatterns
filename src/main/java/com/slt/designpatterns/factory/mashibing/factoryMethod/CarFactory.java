package com.slt.designpatterns.factory.mashibing.factoryMethod;

import com.slt.designpatterns.factory.mashibing.Car;
import com.slt.designpatterns.factory.mashibing.Moveable;

/**
 * 工厂方法
 * 任意定制生成过程
 */
public class CarFactory {
    public Moveable create() {
        System.out.println("a car created!");//日志操作
        return new Car();
    }
}
