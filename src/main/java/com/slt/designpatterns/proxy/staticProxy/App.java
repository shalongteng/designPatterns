package com.slt.designpatterns.proxy.staticProxy;

/**
 * 代理(Proxy)是一种设计模式,提供了对目标对象另外的访问方式;即通过代理对象访问目标对象.
 * 这样做的好处是:增强额外的功能操作,即扩展目标对象的功能.
 * 这里使用到编程中的一个思想:不要随意去修改别人已经写好的代码或者方法,如果需改修改,可以通过代理的方式来扩展该方法
 *
 */
public class App {
    /**
    　* @Description:静态代理总结:
     1.可以做到在不修改目标对象的功能前提下,对目标功能扩展.
     2.注意:
         代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.
         同时,一旦接口增加方法,目标对象与代理对象都要维护.
    　* @author shalongteng
    　* @date 2020/7/20 17:21
    　*/
    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDao();

        //代理对象,把目标对象传给代理对象,建立代理关系
        UserDaoProxy proxy = new UserDaoProxy(target);

        proxy.save("123");//执行的是代理的方法
    }
}
