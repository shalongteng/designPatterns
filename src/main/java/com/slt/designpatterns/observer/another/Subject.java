package com.slt.designpatterns.observer.another;

import java.util.ArrayList;
import java.util.List;

public class Subject {
   //存放 观察者list
   private List<Observer> observers = new ArrayList<Observer>();
   private int state;

   //观察者时刻观察这 这个状态的变化
   public int getState() {
      return state;
   }

   public void setState(int state) {
      this.state = state;
      //状态发生变化 ，通知所有的观察者
      notifyAllObservers();
   }

   public void attach(Observer observer){
      observers.add(observer);
   }

   public void notifyAllObservers(){
      for (Observer observer : observers) {
         observer.update();
      }
   }
}
