package com.chensee.collection.common;

import com.chensee.model.Singleton.Singleton;

/**
 * @author ah
 * @title: SingleTon
 * @date 2020/5/6 11:55
 */
public class SingleTon {

    private static SingleTon singleTon = null;

    private SingleTon(){
    }

    public static SingleTon getInstance(){
        if (singleTon == null) {
            synchronized (Singleton.class) {
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
