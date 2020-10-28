package com.slt.designpatterns.builder;

public class Main {
    public static void main(String[] args) {
        TerrainBuilder builder = new ComplexTerrainBuilder();
        //链式编程
        Terrain t = builder.buildFort().buildMine().buildWall().build();
        //new Terrain(Wall w, Fort f, Mine m)
        //Effective Java

        /**
         * java 中的一种使用方式
         * 如果是一个构造器，那么不使用的属性也得传空值。
         * 用到的部分 就指定
         * 比如score 不用，那么不指定即可
         */
        Person p = new Person.PersonBuilder()
                .basicInfo(1, "zhangsan", 18)
//                .score(20)
                .weight(200)
//                .loc("bj", "23")
                .build();
        System.out.println(p.loc);
    }
}
