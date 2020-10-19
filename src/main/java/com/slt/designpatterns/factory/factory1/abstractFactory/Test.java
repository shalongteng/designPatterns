package com.slt.designpatterns.factory.factory1.abstractFactory;

/**
 * 创建类模式
 *
 * 作为一种创建类模式，在任何需要生成复杂对象的地方，都可以使用工厂方法模式。有一点需要注意的地方
 * 就是复杂对象适合使用工厂模式，而简单对象，特别是只需要通过new就可以完成创建的对象，无需使用工厂模式。
 * 如果使用工厂模式，就需要引入一个工厂类，会增加系统的复杂度。
 *
 * 抽象工厂模式是工厂方法的仅一步深化，
 * 在这个模式中的工厂类不单单可以创建一种产品，而是可以创建一组产品。
 *
 */
public class Test {

    public static void main(String[] args) {

     Factory factory;
     Gun gun;
     Bullet bullet;

     factory =new AK_Factory();
     bullet=factory.produceBullet();
     bullet.load();

     gun=factory.produceGun();
     gun.shooting();

    }

}
