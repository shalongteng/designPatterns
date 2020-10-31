package com.slt.designpatterns.strategy.mashibing;

/**
 * 比较器
 * 比较策略
 * @param <T>
 */
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);

    /**
     * 1.8以后可以写默认实现
     * 接口默认实现
     * lambda 表达式 加进来以后
     */
    default void m() {
        System.out.println("m");
    }
}
