package com.slt.designpatterns.proxy2.v03;

import java.util.Random;

/**
 * 使用继承 测试tank move的时间
 *
 * 问题：无法使用源码
 * 缺点：
 *  慎用继承
 *  如果想对tank的move方法加日志 需要再写一个类
 *  关键是如果想对tank测时间 并且加日志 并且还想有顺序。先测时间后加日志
 *  就需要写更多的子类。不够灵活。
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
        new TimeTank().move();
    }
}

class TimeTank extends Tank{
    @Override
    public void move(){
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
interface Movable{
    void move();
}
