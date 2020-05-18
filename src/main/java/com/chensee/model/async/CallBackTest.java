package com.chensee.model.async;

/**
 * java中接口异步回调的机制：
 * 1、接口作为方法参数，其实际传入引用指向的是实现类
 * 2、Client的sendMsg方法中，参数为final，因为要被内部类一个新的线程可以使用。这里就体现了异步。
 * 3、调用server的getClientMsg()，参数传入了Client本身（对应第一点）。
 *
 * 运用场景：
 * 1、Windows平台的消息机制
 * 2、异步调用微信接口，根据微信返回状态对出业务逻辑响应。
 * 3、Servlet中的Filter(过滤器)是基于回调函数，需容器支持。
 *
 */public class CallBackTest {
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(server);
        client.sendMsg("Server,Hello..........");
    }
}
