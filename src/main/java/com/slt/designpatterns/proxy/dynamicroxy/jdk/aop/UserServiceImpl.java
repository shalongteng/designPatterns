package com.slt.designpatterns.proxy.dynamicroxy.jdk.aop;

/**
 * @Description： UserService接口实现类UserServiceImpl 该类 作为AOP中切点角色，
 * 切面定义的方法插入到切点的接口方法 执行前和执行后执行。 <br/>
 */
public class UserServiceImpl implements IUserService {
    @Override
    public void saveUser(String username, String password) throws Exception {
        System.out.println("save user[username=" + username + ",password=" + password + "]");
    }
}
