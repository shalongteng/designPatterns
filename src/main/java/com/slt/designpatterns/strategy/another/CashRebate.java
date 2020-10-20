package com.slt.designpatterns.strategy.another;

/**
 * 打折收费子类
 */
public class CashRebate extends CashSuper {

    private double moneyRebate = 1;    //折扣

    public CashRebate(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    @Override
    public double acceptCash(double money) {
        return money * moneyRebate;
    }

}
