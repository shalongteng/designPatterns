package com.slt.designpatterns.proxy2.v01;

import java.util.Random;

/**
 * @ClassName: Tank
 * @Author: shalongteng
 * @Description: 问题：我想记录坦克移动的时间
 * @Date: 2020-07-21 20:55
 */
public class Tank implements Movable{

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
}


interface Movable{
    void move();
}
