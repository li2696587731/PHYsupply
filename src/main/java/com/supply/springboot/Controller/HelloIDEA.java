package com.supply.springboot.Controller;/**
 * 作者: HelloIDEA-ljh
 * 创建时间: 2018/11/29 11:30
 * 声明:
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName HelloIDEA
 *@Author Junlunet-ljh
 *@Date 2018/11/29 11:30
 *@Version 1.0
 **/
@RestController
public class HelloIDEA {
    @RequestMapping("/Hello")
    public String outsay(){
        return "Hello My First IDEA Demo! GG!";
    }
}
