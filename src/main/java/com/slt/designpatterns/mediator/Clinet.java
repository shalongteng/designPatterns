package com.slt.designpatterns.mediator;

public class Clinet {
    public static void main(String[] args) {
        ConcreteMediator concreteMediator = new ConcreteMediator();
        ConcreteColleagueA concreteColleagueA = new ConcreteColleagueA(concreteMediator);

        concreteColleagueA.operate();
    }
}
