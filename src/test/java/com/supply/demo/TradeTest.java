package com.supply.demo;/**
 * 作者: TradeTest-ljh
 * 创建时间: 2018/12/14 14:06
 * 声明:
 */

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sun.swing.internal.plaf.synth.resources.synth_sv;
import com.supply.springboot.Utils.Digest;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 *@ClassName TradeTest
 *@Author Junlunet-ljh
 *@Date 2018/12/14 14:06
 *@Version 1.0
 **/
@Slf4j
public class TradeTest {
    private String api = "16GWKNVSOWWlBgYgITgHbgXUJlwPo7mc66zvIxxPniM";
    private String secret = "TAxCzBwxZjPjSxWaWNHJJlHCQyWTcR0w1pK4ynQwHjL";
    private static String BITFINEX_PRE_URL = "https://api.bitfinex.com";
    private static String BOOT_URL = "/v1/orders";
    private static String BOOT_URL_CANCEL = "/v1/order/cancel/all";

    @Test
    public void testBitfinex() throws Exception{
        HttpResponse<JsonNode> response = null;
        String payload_base64 = null;
        JSONObject urlpost = new JSONObject();//将请求url存入JSONObject对象中
        urlpost.put("request",BOOT_URL);
        try {
            payload_base64 = Digest.baseDigest(urlpost);
            String payload_sha384hmac = Digest.hmacDigest(payload_base64, secret, "HmacSHA384"); //sha384加密
            response = Unirest.post(BITFINEX_PRE_URL + BOOT_URL)
                    .header("Content-Type", "application/json")
                    .header("Accept","application/json")
                    .header("X-BFX-APIKEY", api)
                    .header( "X-BFX-PAYLOAD", payload_base64)
                    .header("X-BFX-SIGNATURE", payload_sha384hmac)
                    .asJson();
        } catch (UnirestException e) {
            log.debug("BITFINEX:出现异常{}",e.toString());
        }
        JSONArray list;
        list = response.getBody().getArray();
        System.out.println(list.toString());
//        System.out.println(response.toString());
    }

    @Test
    public void Format(){
        /*String s = "3785.1";
        double ds = Double.parseDouble(s);
//        s = new BigDecimal(String.valueOf(ds)).toString();
        String str=new DecimalFormat("0.00").format(ds);
        System.out.println("*1*"+str);*/


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tt = "1444276570.0";
        double dt = Double.parseDouble(tt);
        BigDecimal bt = new BigDecimal(dt*1000);
        String finished = sdf.format(Long.valueOf(bt.toString()));
        System.out.println("*******//***"+finished);
    }

}
