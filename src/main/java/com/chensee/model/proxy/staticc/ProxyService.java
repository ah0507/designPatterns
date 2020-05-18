package com.chensee.model.proxy.staticc;

import com.chensee.model.proxy.IService;
import com.chensee.model.proxy.Service;

/**
 * 代理类
 */
public class ProxyService implements IService {

    private IService iService;

    /**
     * 默认代理Service类
     */
    public ProxyService() {
        this.iService = new Service();
    }

    /**
     * 也可以代理实现相同接口的其他类
     * @param iService
     */
    public ProxyService(IService iService) {
        this.iService = iService;
    }

    @Override
    public void service() {
        System.out.println("开始执行service()方法");
        iService.service();
        System.out.println("service()方法执行完毕");
    }
}
