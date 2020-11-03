package com.slt.designpatterns.visitor;

/**
 * 模拟的是 攒机
 */
public class Computer {
    ComputerPart cpu = new CPU();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();

    public void acccept(Visitor v) {
        this.cpu.accept(v);
        this.memory.accept(v);
        this.board.accept(v);
    }

    public static void main(String[] args) {
        PersonelVisitor p = new PersonelVisitor();
        new Computer().acccept(p);
        System.out.println(p.totalPrice);
    }
}












