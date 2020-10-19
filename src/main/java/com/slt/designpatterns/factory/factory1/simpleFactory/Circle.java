package com.slt.designpatterns.factory.factory1.simpleFactory;

/**
 * 创建实现该接口的具体图形类
 *
 */
public class Circle implements Shape {
    public Circle() {
        System.out.println("Circle");
    }

    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }
}
