package com.slt.designpatterns.state.v1;

/**
 * 当增加新的状态时非常不方便
 * 一个类里的动作 根据他的状态不同 而不同
 */
public class MM {
    private enum MMState {HAPPY, SAD}

    String name;
    MMState state;

    public void smile() {
        //switch case
    }

    public void cry() {
        //switch case
    }

    public void say() {
        //switch case
    }
}
