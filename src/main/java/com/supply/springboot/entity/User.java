package com.supply.springboot.entity;/**
 * 作者: User-ljh
 * 创建时间: 2018/11/29 16:22
 * 声明:
 */

import lombok.Data;
import javax.persistence.*;

/**
 *@ClassName User
 *@Author Junlunet-ljh
 *@Date 2018/11/29 16:22
 *@Version 1.0
 **/

@Entity
@Table(name = "t_user")
@Data public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "user_name",nullable = false,length = 30)
    private  String userName;

    @Column(name = "user_type",nullable = true,length = 15)
    private  String userType;

    @Column(name = "user_tel",nullable = true,length = 15)
    private String userTel;


}
