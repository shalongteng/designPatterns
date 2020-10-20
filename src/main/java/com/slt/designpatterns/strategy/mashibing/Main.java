package com.slt.designpatterns.strategy.mashibing;

import org.junit.Test;

import java.util.Arrays;

/**
 * writing tests first!
 * extreme programming
 */
public class Main {
    public static void main(String[] args) {

        //int[] a = {9, 2, 3, 5, 7, 1, 4};
        Cat[] a = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};
        Dog[] dogArray = {new Dog(3), new Dog(5), new Dog(1)};
        Sorter<Cat> sorter = new Sorter<>();
//        sorter.sort1(a);
//        sorter.sort2(a);

        /**
         * sort3 是策略模式
         */
        sorter.sort3(a, (o1, o2)->{
            if(o1.weight < o2.weight) return -1;
            else if (o1.weight>o2.weight) return 1;
            else return 0;
        });
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testCat(){
        Sorter<Cat> sorter = new Sorter<>();
        Cat[] catArray = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};


        sorter.sort3(catArray,new CatHeightComparator());
        System.out.println(Arrays.toString(catArray));
    }

    @Test
    public void testDog(){
        Sorter<Dog> sorter = new Sorter<>();
        Dog[] dogArray = {new Dog(3), new Dog(5), new Dog(1)};

        sorter.sort3(dogArray,new DogComparator());
        System.out.println(Arrays.toString(dogArray));
    }
}
