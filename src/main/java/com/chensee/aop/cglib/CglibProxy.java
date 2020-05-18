package com.chensee.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ah
 * @title: CglibProxy
 * @date 2020/5/5 13:28
 */
public class CglibProxy implements MethodInterceptor {

    /**
     * 被代理的目标对象
     */
    private Object targetObject;

    public Object createProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetObject.getClass());// 设置代理目标
        enhancer.setCallback(this);// 设置回调
        return enhancer.create();
    }

    /**
     *      * 在代理实例上处理方法调用并返回结果 
     *      * @param object ： 代理类
     *      * @param method ：被代理的方法
     *      * @param args ：该方法的参数数组
     *      * @param methodProxy
     *     
     */
    @Override
    public Object intercept(Object object, Method method, Object[] args,
                            MethodProxy methodproxy) throws Throwable {
        Object result = null;
        try {
            System.out.println("前置处理开始 ...");
            result = methodproxy.invoke(targetObject, args);//执行目标对象的方法
            System.out.println("后置处理开始  ...");
        } catch (Exception e) {
            System.out.println("异常处理 ...");
        } finally {
            System.out.println("调用结束 ...");
        }
        return result;
    }
}
