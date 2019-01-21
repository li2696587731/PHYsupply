package com.supply.springboot.Controller;/**
 * 作者: Test-ljh
 * 创建时间: 2018/12/5 13:12
 * 声明:
 */

import com.alibaba.fastjson.JSON;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;


/**
 *@ClassName Test
 *@Author Junlunet-ljh
 *@Date 2018/12/5 13:12
 *@Version 1.0
 **/
public class Test {
    /*public void contextLoads() throws URISyntaxException, InterruptedException, IOException {
        WebSocketClient client = new WebSocketClient(new URI("wss://api.bitfinex.com/ws/2")) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                System.out.println("打开连接");
            }

            @Override
            public void onMessage(String s) {
                System.out.println("收到的字符串数据为：" + s);
            }

            @Override
            public void onMessage(ByteBuffer msg) {
                System.out.println(msg);
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                System.out.println("关闭连接");
            }

            @Override
            public void onError(Exception e) {
                System.out.println("出现异常：" + e);
            }
        };
        //开始连接
        System.out.println("开始连接中");
        boolean b = client.connectBlocking();
        System.out.println(b);
        //等待连接打开
        Map map = new HashMap();
        map.put("event","subscribe");
        map.put("channel","book");
        map.put("chanId","3829");
        map.put("symbol","tBTCUSD");
        map.put("prec","P0");
        map.put("freq","F0");
        map.put("len","25");
        map.put("pair","BTCUSD");


        Map response = new HashMap();
        response.put("event","ping");
        response.put("cid","123456");

        client.send(JSON.toJSONString(map));
        System.out.println("连接成功");
        //发送订阅信息
        Thread.sleep(10000);
        client.close();
        System.out.println("连接已经关闭");
    }*/
}
