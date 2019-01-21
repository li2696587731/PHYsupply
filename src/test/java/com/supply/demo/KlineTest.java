package com.supply.demo;/**
 * 作者: KlineTest-ljh
 * 创建时间: 2018/12/24 11:59
 * 声明:
 */

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.junit.Test;

import java.util.ArrayList;

/**
 *@ClassName KlineTest
 *@Author Junlunet-ljh
 *@Date 2018/12/24 11:59
 *@Version 1.0
 **/
public class KlineTest {
    @Test
    public void Testdd(){
        HttpResponse response = null;
        try {
            response = Unirest.get("https://api.bitfinex.com/v2/candles/trade"+":{TimeFrame}:{Symbol}/{Section}")
                    .routeParam("TimeFrame","1m")
                    .routeParam("Symbol","tBTCUSD")
                    .routeParam("Section","hist")
                    .queryString("limit",500)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        JSONArray joArray = JSON.parseArray(response.getBody().toString());
        System.out.println(joArray.toString());

    }
}
