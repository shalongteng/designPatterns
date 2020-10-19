package com.slt.designpatterns.singleton;


/**
 * 不仅可以解决线程同步，还可以防止反序列化。
 * 前边七中 都可以反射 生成对象
 *
 * 他不会被反序列化，枚举类没有构造方法。
 * 完美版之一
 */
public enum SingletonEnum {
    INSTANCE;

    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            new Thread(()->{
                System.out.println(SingletonEnum.INSTANCE.hashCode());
            }).start();
        }
    }
}
