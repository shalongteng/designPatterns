package com.slt.designpatterns.factory.factory1.simpleFactory;

/**
 * 创建一个可以绘制不同形状的绘图工具，可以绘制圆形，正方形，三角形，每个图形都会有一个draw()方法用于绘图.
 *
 */
public interface Shape {
    void draw();
}
