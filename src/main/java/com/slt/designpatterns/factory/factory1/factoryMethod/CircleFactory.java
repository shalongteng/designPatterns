package com.slt.designpatterns.factory.factory1.factoryMethod;


import com.slt.designpatterns.factory.factory1.simpleFactory.Circle;
import com.slt.designpatterns.factory.factory1.simpleFactory.Shape;

public class CircleFactory implements Factory {

    @Override
    public Shape getShape() {
        return new Circle();
    }

}

