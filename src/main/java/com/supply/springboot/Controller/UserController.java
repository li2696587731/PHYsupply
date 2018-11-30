package com.supply.springboot.Controller;/**
 * 作者: UserController-ljh
 * 创建时间: 2018/11/29 16:52
 * 声明:
 */

import com.supply.springboot.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName UserController
 *@Author Junlunet-ljh
 *@Date 2018/11/29 16:52
 *@Version 1.0
 **/
@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/Name")
    public String getByName(){
        String n1 = "HZ";
        return userDao.findByuserName(n1).toString();
    }

    @RequestMapping("/Tel")
    public String getByTel(){
        String t1 = "13558949496";
        return userDao.findByuserTel(t1).toString();
    }

    @RequestMapping("/All")
    public String getAll(){
        return userDao.findByuserNameNotNull().toString();
    }

}
