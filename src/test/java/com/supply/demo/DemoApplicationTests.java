package com.supply.demo;



import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.supply.springboot.entity.Trade;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoApplicationTests {
    private static String TRADE = "[{\"event\":\"subscribe\",\"channel\":\"trades\",\"symbol\":\"t%s\"}]";
    private Map response = new HashMap();
    private String pio = "ping" ;
    private String cid = "12345";
    private String ts = "";
    private boolean flag = true;


/*    *//**
     * 心跳验证
     *//*
    public void sendpio() throws InterruptedException {
        response.put("event", pio);
        response.put("ts", ts);
        response.put("cid", cid);
        while (flag){
            client.send(JSON.toJSONString(response));
            Thread.sleep(3500);
            sendpio();
        }
    }*/
    @Test
    public void contextLoadsOO() throws InterruptedException, URISyntaxException {
        WebSocketClient client = new WebSocketClient(new URI("wss://api.bitfinex.com/ws/2")) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                System.out.println("打开连接");
            }

            @Override
            public void onMessage(String s) {
                //ObjectMapper mapper = new ObjectMapper();
                //JsonNode node = null;
                /*try {
                    //JsonNode da = mapper.readTree(s);
                    //System.out.print("ID：" + da.get(0) + "***" + da.get(1));
                    //node = da.get(2);
                    System.out.println("进入数据加工");
                    tradeTrim(s);
                    System.out.println("退出数据加工");

                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                System.out.println("收到的数据为：" + s);
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                System.out.println("关闭连接");
            }

            @Override
            public void onMessage(ByteBuffer msg) {
                System.out.println("收到的ByteMSG数据为：" + msg);
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
        //map.put("chanId","3829");
        map.put("symbol","tBTCUSD");
        //map.put("prec","P0");
        //map.put("freq","F0");
        //map.put("len","25");
        //map.put("pair","BTCUSD");
        //map.put("key","trade:1m:tBTCUSD");




        response.put("event", "ping");
        response.put("ts", "1544683338333");
        response.put("cid", "123456");

        Map close = new HashMap();
        close.put("event", "unsubscribe");
        close.put("chanId", "3829");

        //System.out.println("*map***"+map.toString());
        System.out.println("*map***"+map);

/*        String yy = String.format(TRADE,"BTCUSD");
        System.out.println("*yy***"+yy);*/

        /*String ss = JSON.toJSONString(yy).replace("*","\"");
        System.out.println("*ss***"+ss);
        System.out.println("*Jss***"+JSON.toJSONString(ss));*/
/*
        String joyy = JSONObject.quote(yy);
        System.out.println("*joyy***"+joyy);*/
        client.send(JSON.toJSONString(map));
        //client.send(JSON.toJSONString(response));
        System.out.println("连接成功");
        //发送订阅信息
        Thread.sleep(35000);
        client.send(JSON.toJSONString(close));
        client.close();
        System.out.println("连接已经关闭");



    }
}
