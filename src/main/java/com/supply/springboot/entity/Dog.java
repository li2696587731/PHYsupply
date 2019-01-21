package com.supply.springboot.entity;/**
 * 作者: Dog-ljh
 * 创建时间: 2018/12/18 15:46
 * 声明:
 */

import java.awt.font.NumericShaper;

/**
 *@ClassName Dog
 *@Author Junlunet-ljh
 *@Date 2018/12/18 15:46
 *@Version 1.0
 **/
public class Dog implements Comparable<Dog>{

    private int size;

    public Dog(int s) {
        this.size=s;
    }

    public String toString() {
        return size+ "";
    }

    @Override
    public int compareTo(Dog o) {
        int num = this.size - o.size;
        int qq;
        if(num > 0){
            qq = 1;
        }else if(num < 0){
            qq = -1;
        }else{
            qq = 0;
        }
        return qq;
    }

}