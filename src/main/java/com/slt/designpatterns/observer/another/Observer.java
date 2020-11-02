package com.slt.designpatterns.observer.another;

public abstract class Observer {
   //被观察对象
   protected Subject subject;
   public abstract void update();
}
