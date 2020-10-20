package com.slt.designpatterns.strategy.another;

/**
 * 正常收费子类
 */
public class CashNormal extends CashSuper {

    @Override
    public double acceptCash(double money) {
        return money;
    }

}
