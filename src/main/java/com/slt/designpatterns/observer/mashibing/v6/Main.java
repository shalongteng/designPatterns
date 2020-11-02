package com.slt.designpatterns.observer.mashibing.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * 有很多时候，观察者需要根据事件的具体情况来进行处理
 * 加入 事件类 fire Event
 */
class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        //小孩哭的 时间 地点
        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(), "bed");

        for(Observer o : observers) {
            o.actionOnWakeUp(event);
        }
    }
}

//事件类 fire Event  发出事件
class wakeUpEvent{
    long timestamp;//时间
    String loc;//地点

    public wakeUpEvent(long timestamp, String loc) {
        this.timestamp = timestamp;
        this.loc = loc;
    }
}

/**
 * 根据事件 观察者不同的反应
 */
interface Observer {
    void actionOnWakeUp(wakeUpEvent event);
}

class Dad implements Observer {
    public void feed() {
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        feed();
    }
}

class Mum implements Observer {
    public void hug() {
        System.out.println("mum hugging...");
    }

    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        hug();
    }
}

class Dog implements Observer {
    public void wang() {
        System.out.println("dog wang...");
    }

    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        wang();
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        //do sth
        c.wakeUp();
    }
}
