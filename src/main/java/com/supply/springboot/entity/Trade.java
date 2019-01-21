package com.supply.springboot.entity;

import lombok.Data;

/**
 * @Author ISME
 * @Date 2018/1/14
 * @Time 14:52
 */
@Data
public class Trade {
    private String amount;//数量
    private String price;//价格
    private String direction;//方向(买buy卖sell)赋值必须转换为buy或者sell
    private String time;//时间(15:13:50)复制必须转换为此时间格式

}
