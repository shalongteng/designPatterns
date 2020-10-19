package com.slt.designpatterns.proxy.staticProxy;

/**
 * 代理对象,静态代理
 */
public class UserDaoProxy implements IUserDao{
    //接收保存目标对象
    private IUserDao target;
    public UserDaoProxy(IUserDao target){
        this.target=target;
    }

    @Override
    public void save(String name) {
        System.out.println("开始事务...");
        target.save(name);//执行目标对象的方法
        System.out.println("提交事务...");
    }

    @Override
    public void save2() {

    }
}
