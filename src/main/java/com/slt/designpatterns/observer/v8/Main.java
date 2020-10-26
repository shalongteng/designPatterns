package com.slt.designpatterns.observer.v8;

import java.util.ArrayList;
import java.util.List;

/**
 * 事件也可以形成 继承体系
 */
class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());

        //hook callback function
        observers.add((e)->{
            System.out.println("ppp");
        });
    }


    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;

        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(), "bed", this);

        for(Observer o : observers) {
            o.actionOnWakeUp(event);
        }
    }
}

abstract class Event<T> {
    abstract T getSource();
}

class wakeUpEvent extends Event<Child>{
    long timestamp;
    String loc;
    Child source;

    public wakeUpEvent(long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }

    @Override
    Child getSource() {
        return source;
    }
}

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
