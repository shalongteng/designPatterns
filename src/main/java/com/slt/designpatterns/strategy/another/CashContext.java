package com.slt.designpatterns.strategy.another;

/**
 * 上下文类
 * 声明一个CashSuper对象，通过构造方法，传入具体的收费策略，
 * getResult()方法的功能为根据收费策略的不同获得计算结果。
 */
public class CashContext {

    private CashSuper cashSuper;

    public CashContext(CashSuper cashSuper) {
        this.cashSuper = cashSuper;
    }

    public double getResult(double money) {
        return cashSuper.acceptCash(money);
    }

}
