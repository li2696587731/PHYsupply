package com.supply.demo;/**
 * 作者: TestSort-ljh
 * 创建时间: 2018/12/19 14:57
 * 声明:
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *@ClassName TestSort
 *@Author Junlunet-ljh
 *@Date 2018/12/19 14:57
 *@Version 1.0
 **/
public class TestSort {
    @Test
    public void test_1(){
        JSONObject o1 = JSONObject.parseObject("{\"id\":1,\"name\":\"ljw\"}");
        JSONObject o2 = JSONObject.parseObject("{\"id\":3,\"name\":\"ljw\"}");
        JSONObject o3 = JSONObject.parseObject("{\"id\":2,\"name\":\"ljw\"}");
        JSONArray a = new JSONArray();
        a.add(o1);
        a.add(o2);
        a.add(o3);
//转list 1
        List<JSONObject> list = JSONArray.parseArray(a.toJSONString(), JSONObject.class);
//转list 2
//List<JSONObject> list = new ArrayList<JSONObject>();
//for (int i = 0; i < a.size(); i++) {
//    list.add((JSONObject) a.get(i));
//}
        System.out.println("排序前："+a);
        Collections.sort(list, new Comparator<JSONObject>() {
            @Override
            public int compare(JSONObject o1, JSONObject o2) {
                int a = o1.getInteger("id");
                int b = o2.getInteger("id");
                if (a > b) {
                    return 1;
                } else if(a == b) {
                    return 0;
                } else
                    return -1;
            }
        });
        //JSONArray jsonArray = JSONArray.parseArray(list.toString());
        System.out.println("排序后：" + list);
    }
}
