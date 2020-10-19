package com.slt.designpatterns.singleton;

/**
 * 静态内部类方式，JVM保证单例，
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 * 完美版之一
 */
public class Singleton6 {
    private Singleton6() {}  //私有构造函数

    private static class SingletonHolder{
        private static Singleton6 singleton6 = new Singleton6();
    }

    //静态工厂方法
    public static synchronized Singleton6 getInstance() {
        return SingletonHolder.singleton6;
    }
}
