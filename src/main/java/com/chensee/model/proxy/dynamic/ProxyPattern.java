package com.chensee.model.proxy.dynamic;

import com.chensee.model.proxy.IService;
import com.chensee.model.proxy.Service;

import java.lang.reflect.Proxy;

public class ProxyPattern {
    public static void main(String[] args) {
        IService service = new Service();
        Class<? extends IService> clazz = service.getClass();
        IService proxyService = (IService) Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(), new ServiceInvocationHandler(service));
        proxyService.service();
    }
}
