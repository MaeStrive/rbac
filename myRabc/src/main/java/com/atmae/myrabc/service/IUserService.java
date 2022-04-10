package com.atmae.myrabc.service;

import com.atmae.myrabc.entity.User;
import com.atmae.myrabc.vo.ResultDataVo;

/**
 * @Author: Mae
 * @Date: 2022/2/16
 * @Time: 14:10
 * @Description:
 */
public interface IUserService {
    /**
     * 查询用户列表
     * @return
     */
    public ResultDataVo selectUserList(Integer page, Integer limit,String keyword);

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void delUser(Integer id);

    /**
     * 查找用户
     * @param id
     * @return
     */
    User selectById(Integer id);

    /**
     * 检查用户
     * @param username
     * @param password
     * @return
     */
    Boolean check(String username, String password);
}
