package com.chensee;

/**
 * @author ah
 * @title: Test
 * @date 2020/5/13 15:34
 */
public class SingleTon {
    private static volatile SingleTon singleTon = null;

    private SingleTon(){}

    public static SingleTon getSingleTon(){
        if (singleTon == null) {
            synchronized (SingleTon.class) {
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
