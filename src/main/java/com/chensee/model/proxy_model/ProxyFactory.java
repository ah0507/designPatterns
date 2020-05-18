package com.chensee.model.proxy_model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    // 接收一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                Object result;
                if ("find".equals(methodName)) {
                    System.out.println("开始查询...");
                    result = method.invoke(target, args);
                } else {
                    System.out.println("开启事务...");
                    result = method.invoke(target, args);
                    System.out.println("提交事务...");
                }
                return result;
            }
        };
        Object instance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), invocationHandler);
        return instance;
    }
}
