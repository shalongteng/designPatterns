package com.slt.designpatterns.factory.mashibing.factoryMethod;

import com.slt.designpatterns.factory.mashibing.Car;
import com.slt.designpatterns.factory.mashibing.Moveable;
import com.slt.designpatterns.factory.mashibing.Plane;

/**
 * 工厂方法
 * 任意定制交通工具
 * 任意定制生成过程
 */
public class PlaneFactory {
    public Moveable create() {
        //日志操作
        System.out.println("a plane created!");
        return new Plane();
    }
}
