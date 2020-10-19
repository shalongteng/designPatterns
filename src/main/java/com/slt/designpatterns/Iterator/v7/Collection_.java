package com.slt.designpatterns.Iterator.v7;

public interface Collection_<E> {
    void add(E o);
    int size();

    Iterator_ iterator();
}
