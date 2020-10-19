package com.slt.designpatterns.factory.factory1.simpleFactory;

/**
 * 这样的实现有个问题，如果我们新增产品类的话，就需要修改工厂类中的getShape（）方法，这很明显不符合 开放-封闭原则 。
 * 简单工厂（Simple Factory）模式，又称静态工厂方法模式（Static Factory Method Pattern）。
 */
public class ShapeFactory {

    // 使用 getShape 方法获取形状类型的对象
    public static Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}

