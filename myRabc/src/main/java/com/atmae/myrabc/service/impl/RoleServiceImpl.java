package com.atmae.myrabc.service.impl;

import com.atmae.myrabc.entity.Role;
import com.atmae.myrabc.mapper.RoleMapper;
import com.atmae.myrabc.service.IRoleService;
import com.atmae.myrabc.vo.ResultDataVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2022/2/19
 * @Time: 8:52
 * @Description:
 */
@Service
public class RoleServiceImpl implements IRoleService{
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public  ResultDataVo selectRoleList(Integer page, Integer limit){
        ResultDataVo resultDataVo = new ResultDataVo();
        // mybatis分页插件使用
        // 一定要在查询之前
        // page:第几页  limit:每页几条
        PageHelper.startPage(page, limit);
        List<Role> list = roleMapper.selectUserList();
        PageInfo<Role> info = new PageInfo<>(list);
        //获取分页之前表中所有数据
        resultDataVo.setCount(info.getTotal());
        resultDataVo.setData(list);
        return resultDataVo;
    }

}
