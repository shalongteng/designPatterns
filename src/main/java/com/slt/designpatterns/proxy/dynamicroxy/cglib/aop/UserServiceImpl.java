package com.slt.designpatterns.proxy.dynamicroxy.cglib.aop;

/**
 * @Description： 业务实现类UserServiceImpl 该类 作为AOP中切点角色，
 * 切面定义的方法插入到切点的接口方法 执行前和执行后执行。 <br/>
 */
public class UserServiceImpl {
    public void saveUser(String username, String password) {
        System.out.println("cglib save user[username=" + username + ",password=" + password + "]");
    }
}
