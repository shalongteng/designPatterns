package com.slt.designpatterns.singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 */
public class Singleton2 {
    private Singleton2() {}  //私有构造函数
    private static Singleton2 instance = null;  //单例对象
    //静态工厂方法
    /**
     * 线程不安全
     * 如果两个线程同时判断 instance == null 成立，
     * 这样一来，显然instance被构建了两次。
     *
     * 如果在方法前加synchronized，效率太低
     */
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Singleton2.getInstance().hashCode())).start();
        }
    }
}
