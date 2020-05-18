package com.chensee.aop;

/**
 * @author ah
 * @title: TestServiceImpl
 * @date 2020/5/5 13:25
 */
public class TestServiceImpl implements TestService {
    @Override
    public void add() {
        System.out.println("开始执行add");
    }
}
