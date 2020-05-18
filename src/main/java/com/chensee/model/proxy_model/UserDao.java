package com.chensee.model.proxy_model;

public class UserDao implements IUserDao{

    public int num;
    private String type;

    public UserDao() {
        System.out.println("无参构造");
    }

    @Override
    public void save() {
        System.out.println("模拟： 保存用户！");
    }

    @Override
    public void find() {
        System.out.println("查询");
    }

    @Override
    public void delete(String userId) {
        System.out.println("删除"+userId);
    }
}
