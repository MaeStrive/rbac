package com.atmae.myrabc.service.impl;

import com.atmae.myrabc.entity.User;
import com.atmae.myrabc.excption.MyException;
import com.atmae.myrabc.mapper.UserMapper;
import com.atmae.myrabc.service.IUserService;
import com.atmae.myrabc.utils.SessionUtil;
import com.atmae.myrabc.vo.ResultDataVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @Author: Mae
 * @Date: 2022/2/16
 * @Time: 14:10
 * @Description:
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultDataVo selectUserList(Integer page, Integer limit, String keyword) {
        ResultDataVo resultDataVo = new ResultDataVo();
        // mybatis分页插件使用
        // 一定要在查询之前
        // page:第几页  limit:每页几条
        PageHelper.startPage(page, limit);
        List<User> list = userMapper.selectUserList(keyword);
        PageInfo<User> info = new PageInfo<>(list);
        //获取分页之前表中所有数据
        resultDataVo.setCount(info.getTotal());
        resultDataVo.setData(list);
        return resultDataVo;
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() == null) {
            User user1 = userMapper.selectByUsername(user.getUsername());
            if (user1 != null) {
                //当前要新增的用户的用户名已经被别人使用
                throw new MyException("用户名已被占用");
            }
            userMapper.insert(user);
        } else {
            userMapper.update(user);
        }
    }

    @Override
    public void delUser(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public Boolean check(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            return false;
        } else {
            Boolean b = user.getPassword().equals(password);
            if (b) {
                //保存登录凭证
                SessionUtil.getSession().setAttribute("current", user);
            }
            return b;
        }
    }
}
