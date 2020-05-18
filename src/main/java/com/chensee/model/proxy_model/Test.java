package com.chensee.model.proxy_model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        IUserDao iUserDao = new UserDao();
        System.out.println("目标对象:"+iUserDao.getClass());
        IUserDao proxyInstance = (IUserDao) new ProxyFactory(iUserDao).getProxyInstance();
        System.out.println("代理对象："+proxyInstance.getClass());
        proxyInstance.save();
        proxyInstance.find();
        System.out.println("1--------------");
        try {
            Class clazz = Class.forName("com.chensee.model.proxy_model.UserDao");
            UserDao userDao = (UserDao) clazz.getConstructor().newInstance();
            userDao.find();
            System.out.println("2--------------");
            Field num = clazz.getField("num");
            Field type = clazz.getDeclaredField("type");
            type.setAccessible(true);//对私有字段的访问取消检查
            UserDao userDao1 = (UserDao)clazz.newInstance();
            num.set(userDao1,1);
            type.set(userDao1,"私有");
            Object num1 = num.get(userDao1);
            Object type1 = type.get(userDao1);
            System.out.println(num1+"--"+type1);
            System.out.println("3--------------");
            Constructor<UserDao> UserDaoConstructor = clazz.getConstructor();
            UserDao userDao2 = UserDaoConstructor.newInstance();
            Method method = clazz.getMethod("find", null);
            method.invoke(userDao2,null);

            method = clazz.getMethod("delete",String.class);
            method.invoke(userDao2,"zhangsan");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
