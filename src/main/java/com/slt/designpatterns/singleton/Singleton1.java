package com.slt.designpatterns.singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * jvm 保证每个Class load到内存一次
 * 简单实用，推荐使用！
 *
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 */
public class Singleton1 {
    private Singleton1() {}  //私有构造函数
    private static Singleton1 instance = new Singleton1();  //单例对象
    //静态工厂方法
    public static Singleton1 getInstance() {
        return instance;
    }
}
