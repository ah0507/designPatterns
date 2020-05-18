package com.chensee.servlet;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author ah
 * @title: test
 * @date 2019/11/28 13:56
 */
public class test {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Runnable() {
                @Override
                public void run() {
                    try {
                        MyWebSocketClient myWebSocketClient = new MyWebSocketClient(new URI("ws://localhost:8887/websocket/" + finalI));
                        myWebSocketClient.connect();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }.run();
        }
    }
}
