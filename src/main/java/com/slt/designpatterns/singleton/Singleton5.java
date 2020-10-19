package com.slt.designpatterns.singleton;

/**
 * 懒汉模式。 双重检查 + volatile
 * 双重检查如果不加volatile，依然线程不安全
 * 因为 new 不是原子操作
 *         new 指令   //1：分配对象的内存空间
 *         invoksepcial 调用init 方法  //2：初始化对象
 *         astore_1  //3. 将引用和对象 建立连接
 * 指令顺序可能会经过JVM优化，重排成1 3 2当线程A执行完1,3,时，instance对象还未完成初始化，但已经不再指向null。
 * 此时如果线程B抢占到CPU资源，执行 if（instance == null）的结果会是false，从而返回一个没有初始化完成的instance对象。
 *
 * 如何避免这一情况呢？我们需要在instance对象前面增加一个修饰符volatile。
 */
public class Singleton5 {
    private Singleton5() {}  //私有构造函数

    /**
     * volitile的作用
     *  禁止指令重排 （实现有序性）
     *  内存可见
     *
     *  volatile读的内存语义如下：
     *    当读一个volatile变量时，JMM会把该线程对应的本地内存置为无效。线程接下来将从主内存中读取共享变量。
     */
    private volatile static Singleton5 instance = null;  //单例对象
    //静态工厂方法
    public static synchronized Singleton5 getInstance() {
        /**
         * 进入Synchronized 临界区以后，还要再做一次判空。因为当两个线程同时访问的时候，线程A构建完对象，
         * 线程B也已经通过了最初的判空验证，不做第二次判空的话，线程B还是会再次构建instance对象
         */
        if (instance == null) {
            synchronized (Singleton5.class){
                if (instance == null) {     //双重检测机制
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
