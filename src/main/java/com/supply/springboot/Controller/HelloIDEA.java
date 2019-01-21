package com.supply.springboot.Controller;/**
 * 作者: HelloIDEA-ljh
 * 创建时间: 2018/11/29 11:30
 * 声明:
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

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

/*    @RequestMapping("/test")
    public String test(){
        Test t1 = new Test();
        try {
            t1.contextLoads();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t1.toString();
    }*/
}
