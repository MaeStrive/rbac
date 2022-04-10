package com.atmae.myrabc.mapper;

import com.atmae.myrabc.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2022/2/19
 * @Time: 8:51
 * @Description:
 */
public interface RoleMapper {

    @Select("select * from role")
    List<Role> selectUserList();
}
