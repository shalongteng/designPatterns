package com.slt.designpatterns.observer.mashibing.v3;

/**
 * 加入观察者
 */
class Child {
    private boolean cry = false;
    //加入观察者
    private Dad d = new Dad();

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        d.feed();
    }
}

class Dad {
    public void feed() {
        System.out.println("dad feeding...");
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        //do sth
        c.wakeUp();
    }
}
