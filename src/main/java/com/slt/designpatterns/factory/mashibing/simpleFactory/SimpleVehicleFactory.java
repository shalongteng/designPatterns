package com.slt.designpatterns.factory.mashibing.simpleFactory;

import com.slt.designpatterns.factory.mashibing.Broom;
import com.slt.designpatterns.factory.mashibing.Car;
import com.slt.designpatterns.factory.mashibing.Plane;

/**
 * 简单工厂
 * 缺点：可扩展性不好
 * 新添加一个交通工具时候，需要新加一个方法。
 *
 * 任意定制交通工具
 */
public class SimpleVehicleFactory {
    public Car createCar() {
        //before processing  加一些处理
        return new Car();
    }

    public Broom createBroom() {
        //可以加一些权限控制
        return new Broom();
    }

    public Plane createPlane() {
        return new Plane();
    }
}
