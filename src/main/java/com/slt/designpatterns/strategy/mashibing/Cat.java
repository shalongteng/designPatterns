package com.slt.designpatterns.strategy.mashibing;

/**
 * 猫比较大小
 * implements Comparable<Cat> 只能实现一种比较方式
 *
 * 如果使用Comparator  可以写多个比较方式
 */
public class Cat implements Comparable<Cat> {
    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public int compareTo(Cat c) {
        if(this.weight < c.weight) return -1;
        else if(this.weight > c.weight) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
