package com.supply.demo;/**
 * 作者: TestSet-ljh
 * 创建时间: 2018/12/18 11:55
 * 声明:
 */

import com.supply.springboot.entity.Dog;
import org.junit.Test;

import java.util.*;

/**
 *@ClassName TestSet
 *@Author Junlunet-ljh
 *@Date 2018/12/18 11:55
 *@Version 1.0
 **/
public class TestSet {


    @Test
    public void TestTreeSet(){
        TreeSet<Dog> dset = new TreeSet<Dog>();

        dset.add(new Dog(3561));

        dset.add(new Dog(7));

        dset.add(new Dog(3));

        dset.add(new Dog(5));

        dset.add(new Dog(4));

        dset.add(new Dog(4));

        Iterator<Dog> iterator= dset.iterator();

        while(iterator.hasNext()) {

            System.out.print(iterator.next()+" ");

        }
        System.out.println("--------------------");
        System.out.println(dset.first());
    }

}
