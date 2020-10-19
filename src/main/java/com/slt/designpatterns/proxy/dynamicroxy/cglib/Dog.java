package com.slt.designpatterns.proxy.dynamicroxy.cglib;

/**
 * @Description： Cglib 代理模式中 被代理的委托类 <br/>
 */
public class Dog {
    public String call() {
        System.out.println("wang wang wang");
        return "Dog ..";
    }
}
