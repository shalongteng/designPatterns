package com.slt.designpatterns.singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 *
 * 可以通过synchronized解决，但也带来效率下降
 */
public class Singleton3 {
    private Singleton3() {}  //私有构造函数
    private static Singleton3 instance = null;  //单例对象
    //静态工厂方法

    /**
     * 可以通过synchronized解决，但也带来效率下降
     * @return
     */
    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
