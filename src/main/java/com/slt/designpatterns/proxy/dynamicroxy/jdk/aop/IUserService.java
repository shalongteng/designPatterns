package com.slt.designpatterns.proxy.dynamicroxy.jdk.aop;

/**
 * @Package: org.vincent.aop.dynamicproxy <br/>
 * @Description： AOP基于动态代理 实现  <br/>
 */
public interface IUserService {
    void saveUser(String username, String password) throws Exception;
}
