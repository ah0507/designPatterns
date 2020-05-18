package com.chensee.aop;

import org.springframework.stereotype.Component;

/**
 * @author gaohang
 * @title: BaseService
 * @projectName DesignPatterns
 * @date 2019/10/12 16:34
 */
@Component
public class BaseService {

    @AoundAnnotation
    public boolean anoundTest(String str,Integer a) throws Exception{
        System.out.println("进入了方法，执行业务...");
        System.out.println(str);
        System.out.println(a);
        return true;
    }
}
