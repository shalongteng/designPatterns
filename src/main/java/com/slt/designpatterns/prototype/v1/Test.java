package com.slt.designpatterns.prototype.v1;

/**
 * 浅克隆
 * protected:    https://blog.csdn.net/asahinokawa/article/details/80777302
 *  若子类与父类不在同一包中，那么在子类中，子类实例可以访问其从父类继承而来的protected方法，
 *  而不能访问父类实例的protected方法。
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person();
        Person p2 = (Person)p1.clone();
        System.out.println(p1.age + " " + p1.score);
        System.out.println(p2.age + " " + p2.score);
        System.out.println(p2.loc);

        System.out.println(p1.loc == p2.loc);
        p1.loc.street = "sh";
        System.out.println(p2.loc);

    }
}
/**
 * 如果只重写clone方法，不实现接口，调用会报错
 */
class Person implements Cloneable{
    int age = 8;
    int score = 100;
    Location loc = new Location("bj", 22);

    /**
     * protected方法可以在包内 或者子类方法中访问
     *  但是不能不能在包外，以子类实例对象来调用 new Person().clone() 这样就会报错。
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


class Location {
    String street;
    int roomNo;

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }
}
