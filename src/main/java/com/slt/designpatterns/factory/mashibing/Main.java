package com.slt.designpatterns.factory.mashibing;

import com.slt.designpatterns.factory.mashibing.factoryMethod.CarFactory;
import org.junit.Test;

public class Main {
    public static void main(String[] args) {
        Moveable m = new CarFactory().create();
        m.go();

    }

    /**
     * 对这些交通工具 简历一个父类
     * 这样扩展就容易多了。
     *
     * 产生对象
     */
    @Test
    public void test01(){
        //开汽车
        Car car = new Car();
        car.go();
        //开飞机
        Plane plane = new Plane();
        plane.go();

        //骑扫帚
        Moveable moveable = new Broom();
        moveable.go();
    }
}
