package com.slt.designpatterns.observer.v2;

/**
 * 面向对象的傻等
 * 跟版本1 没什么区别
 */
class Child {
    private boolean cry = false;

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        System.out.println("Waked Up! Crying wuwuwuwu...");
        cry = true;
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        //如果小孩没哭 就保持观察
        while(!child.isCry()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //保持观察
            System.out.println("observing...");
        }

    }
}
