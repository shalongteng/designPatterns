package com.slt.designpatterns.proxy2.v06;

import java.util.Random;

/**
 *
 * 使用代理   Movable 实现接口 可以实现代理之间的互相嵌套
 * 代理有各种类型
 * 问题：如何实现代理的各种组合？继承？decorator
 * 代理对象改成 movable 原来越像 decorator了
 *
 * 后面的模式：也就是多态的运用
 */
public class Tank implements Movable {

    /**
     * 模拟坦克移动了一段时间
     */
    @Override
    public void move() {
        System.out.println("tank moving caclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
    //代理 就可以嵌套了
    public static void main(String[] args) {
        new TankLogProxy(new TankTimeProxy(new Tank())).move();
    }
}

class TankTimeProxy implements Movable {
    Movable m;

    public TankTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

/**
 * 实现接口 可以实现代理之间的互相嵌套
 */
class TankLogProxy implements Movable {
    Movable m;

    public TankLogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("starting moving");
        m.move();
        long end = System.currentTimeMillis();
        System.out.println("end moving");
    }
}

interface Movable{
    void move();
}
