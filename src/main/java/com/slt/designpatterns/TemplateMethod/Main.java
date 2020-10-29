package com.slt.designpatterns.TemplateMethod;

public class Main {
    public static void main(String[] args) {
        Father father = new C1();
        father.m();
    }

}

abstract class Father {
    //m 就是定义的模板
    public void m() {
        op1();
        op2();
    }
    //钩子函数 由子类实现
    abstract void op1();
    abstract void op2();
}

class C1 extends Father {

    @Override
    void op1() {
        System.out.println("op1");
    }

    @Override
    void op2() {
        System.out.println("op2");
    }
}
