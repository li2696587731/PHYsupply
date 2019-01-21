package com.supply.springboot.Dao;

import com.supply.springboot.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 作者: UserDao-ljh
 * 创建时间: 2018/11/29 16:44
 * 声明:
 */
@Transactional
public interface UserDao extends JpaRepository<User,Integer> {
    //第一个参数User表示所操作的实体类名称，第二个参数Integer表示实体类中主键的类型
    //遍历用户数据
    List<User> findByuserNameNotNull();

    User findByuserTel(String userTel);

    User findByuserName(String userName);

    //分页功能
    Page<User> findByuserNameNotNull(Pageable pageable);

    //添加用户
    @Modifying
    @Query(value = "insert into t_user(user_name,user_type,user_tel)values(:name ,:type ,:tel)",nativeQuery = true)
    Boolean addUser(@Param("name") String name,@Param("type")String type,@Param("tel")String tel);




}
