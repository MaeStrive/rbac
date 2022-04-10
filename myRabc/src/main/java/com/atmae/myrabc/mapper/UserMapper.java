package com.atmae.myrabc.mapper;

import com.atmae.myrabc.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

/**
 * @Author: Mae
 * @Date: 2022/2/16
 * @Time: 14:26
 * @Description:
 */
public interface UserMapper {

    /**
     * 数据库中查询所有用户
     *
     * @return
     */
    List<User> selectUserList(String keyword);

    /**
     * 保存用户
     *
     * @param user
     */
    @Insert("insert into user(username,password,name,age,sex,address) values (#{username},#{password},#{name},#{age},#{sex},#{address})")
    void insert(User user);

    @Delete("delete from user where id=#{id}")
    void deleteById(Integer id);

    @Select("select * from user where id=#{id}")
    User selectById(Integer id);

    /**
     * 更改
     *
     * @param user
     */
    @Update("update user set username=#{username},password=#{password},name=#{name},age=#{age},sex=#{sex},address=#{address} where id=#{id}")
    void update(User user);

    @Select("select * from user where username=#{username}")
    User selectByUsername(String username);
}
