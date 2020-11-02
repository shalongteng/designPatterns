package com.slt.designpatterns.observer.mashibing.v5;

import java.util.ArrayList;
import java.util.List;

/**
 * 分离观察者与被观察者
 */
class Child {
    private boolean cry = false;
    private List<Observer> observerList = new ArrayList<>();
    {
        observerList.add(new Dad());
        observerList.add(new Mum());
        observerList.add(new Dog());
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        for(Observer o : observerList) {
            o.actionOnWakeUp();
        }
    }
}

interface Observer {
    void actionOnWakeUp();
}

class Dad implements Observer {
    public void feed() {
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWakeUp() {
        feed();
    }
}

class Mum implements Observer {
    public void hug() {
        System.out.println("mum hugging...");
    }

    @Override
    public void actionOnWakeUp() {
        hug();
    }
}

class Dog implements Observer {
    public void wang() {
        System.out.println("dog wang...");
    }

    @Override
    public void actionOnWakeUp() {
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
