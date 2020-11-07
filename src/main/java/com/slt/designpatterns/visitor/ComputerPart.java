package com.slt.designpatterns.visitor;

abstract class ComputerPart {
    abstract void accept(Visitor v);
    //some other operations eg:getName getBrand
    abstract double getPrice();
}
