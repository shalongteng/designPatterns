package com.slt.designpatterns.strategy.mashibing;

@FunctionalInterface
public interface Comparable<T> {
    int compareTo(T o);
}
