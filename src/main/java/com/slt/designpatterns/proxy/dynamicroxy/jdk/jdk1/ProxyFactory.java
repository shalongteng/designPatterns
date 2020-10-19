package com.slt.designpatterns.proxy.dynamicroxy.jdk.jdk1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理不需要实现接口,但是需要指定接口类型
 *
 * 基于 JDK 实现动态代理，通过jdk提供的工具方法Proxy.newProxyInstance动态构建全新的代理类
 * (继承Proxy类，并持有InvocationHandler接口引用 )字节码文件并实例化对象返回。
 * (jdk动态代理是由java内部的反射机制来实例化代理对象，并代理的调用委托类方法)
 */
public class ProxyFactory{

    //维护一个目标对象
    private Object target;
    public ProxyFactory(Object target){
        this.target=target;
    }

   //给目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {//事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = new Object();
                        //对不同的方法 进行不同的修改
                        if(method.getName().equals("save")){
                            System.out.println("开始事务2");
                            //执行目标对象方法
                            returnValue = method.invoke(target, args);
                            System.out.println("提交事务2");
                            return returnValue;
                        }else if(method.getName().equals("save2")){
                            System.out.println("开始事务3");
                            //执行目标对象方法
                            returnValue = method.invoke(target, args);
                            System.out.println("提交事务3");
                            return returnValue;
                        }
                        return returnValue;
                    }
                }
        );
    }

}
