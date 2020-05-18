package com.chensee.model.proxy.staticc;

import com.chensee.model.proxy.IService;
import com.chensee.model.proxy.Service;

/**
 *
 */
public class Test {
    public static void main(String[] args) {
        IService proxyService = new ProxyService(new Service());
        proxyService.service();
    }
}
