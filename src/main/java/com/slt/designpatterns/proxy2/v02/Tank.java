package com.slt.designpatterns.proxy2.v02;

import java.util.Random;

/**
 * 问题：我想记录坦克移动的时间
 * 最简单办法：修改代码，记录时间
 * 问题2：如果无法修改源码呢。
 * benchmark : 性能测试
 */
public class Tank implements Movable {

    /**
     * 模拟坦克移动了一段时间
     */
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("tank moving caclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    public static void main(String[] args) {
        new Tank().move();
    }
}


interface Movable{
    void move();
}
