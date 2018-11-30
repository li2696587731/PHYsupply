package com.supply.springboot.Dao;

import com.supply.springboot.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import javax.transaction.Transactional;
import java.util.List;

/**
 * 作者: UserDao-ljh
 * 创建时间: 2018/11/29 16:44
 * 声明:
 */
@Transactional
public interface UserDao extends CrudRepository<User,Integer> {
    //第一个参数User表示所操作的实体类名称，第二个参数Integer表示实体类中主键的类型
    //遍历用户数据
    public List<User> findByuserNameNotNull();

    public User findByuserTel(String userTel);

    public User findByuserName(String userName);

    //分页功能
    public Page<User> findByuserNameNotNull(Pageable pageable);

}
