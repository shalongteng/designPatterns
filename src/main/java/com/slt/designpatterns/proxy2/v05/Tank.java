package com.slt.designpatterns.proxy2.v05;

import java.util.Random;

/**
 * 问题：我想记录坦克移动的时间
 * 最简单办法：修改代码，记录时间
 * 问题2：如果无法修改源码呢。
 * benchmark : 性能测试 需要测试每个方法运行的时间
 *
 * 使用代理0000
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
    public static void main(String[] args) {
        new TankTimeProxy(new Tank()).move();
    }
}

class TankTimeProxy implements Movable {
    Tank tank;

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class TankLogProxy implements Movable {
    Tank tank;

    public TankLogProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        System.out.println("starting moving");
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println("end moving");
    }
}

interface Movable{
    void move();
}
