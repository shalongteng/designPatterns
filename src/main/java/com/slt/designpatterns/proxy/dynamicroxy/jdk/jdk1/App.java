//package com.slt.designpatterns.proxy.dynamicroxy.jdk.jdk1;
//
//import com.slt.java_basics.designPatterns.proxy.staticProxy.IUserDao;
//import com.slt.java_basics.designPatterns.proxy.staticProxy.UserDao;
//
///**
// * 测试类
// * 代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理
// */
//public class App {
//    public static void main(String[] args) {
//        // 目标对象
//        IUserDao target = new UserDao();
//        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
//        System.out.println(target.getClass());
//
//        // 给目标对象，创建代理对象
//        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
//        // class $Proxy0   内存中动态生成的代理对象
//        System.out.println(proxy.getClass());
//
//        // 执行方法   【代理对象】
//        proxy.save("123");
//        proxy.save2();
//    }
//}
