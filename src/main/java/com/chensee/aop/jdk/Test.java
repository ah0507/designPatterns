package com.chensee.aop.jdk;

import com.chensee.aop.TestService;
import com.chensee.aop.TestServiceImpl;

/**
 * @author ah
 * @title: Test
 * @date 2020/5/5 13:26
 */
public class Test {
    public static void main(String[] args) {
        //我们要代理的真实对象
        TestService testService = new TestServiceImpl();
        //testJDKProxyService.add();//不是用代理
        JDKDynamicProxy JDKDynamicProxyTarget = new JDKDynamicProxy();
        TestService testServiceProxy = (TestService) JDKDynamicProxyTarget.newProxy(testService);
        //执行代理类的方法
        testServiceProxy.add();
    }
}
