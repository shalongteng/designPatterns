package com.slt.designpatterns.singleton;

/**
 * 懒汉模式。
 * 双重检查 依然线程不安全
 */
public class Singleton4 {
    private Singleton4() {}  //私有构造函数
    private static Singleton4 instance = null;  //单例对象
    //静态工厂方法
    public static synchronized Singleton4 getInstance() {
        /**
         * 进入Synchronized 临界区以后，还要再做一次判空。因为当两个线程同时访问的时候，线程A构建完对象，
         * 线程B也已经通过了最初的判空验证，不做第二次判空的话，线程B还是会再次构建instance对象
         */
        if (instance == null) {
            synchronized (Singleton4.class){
                if (instance == null) {     //双重检测机制
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
