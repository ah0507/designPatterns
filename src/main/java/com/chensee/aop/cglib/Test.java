package com.chensee.aop.cglib;

import com.chensee.aop.TestService;
import com.chensee.aop.TestServiceImpl;

/**
 * @author ah
 * @title: Test
 * @date 2020/5/5 13:31
 */
public class Test {
    public static void main(String[] args) {
        //我们要代理的真实对象
        TestService testCGLIB = new TestServiceImpl();
        CglibProxy CGLIBproxy = new CglibProxy();
        TestService testCGLIBProxy = (TestService) CGLIBproxy.createProxyInstance(testCGLIB);
        testCGLIBProxy.add();
    }
}
