package com.slt.designpatterns.proxy.staticProxy;

/**
 * 接口实现
 * 目标对象
 */
public class UserDao implements IUserDao {
    public void save(String name) {
        System.out.println("----已经保存" + name +"数据!----");
    }

    @Override
    public void save2() {

    }

    public void save3() {
        System.out.println("save3333");
    }
}
