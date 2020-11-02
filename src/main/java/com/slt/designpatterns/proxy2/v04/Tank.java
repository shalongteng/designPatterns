package com.slt.designpatterns.proxy2.v04;

import java.util.Random;

/**
 * 使用代理 代理tank类型
 *
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

/**
 * 聚合
 */
class TankTimeProxy implements Movable{
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

interface Movable{
    void move();
}
