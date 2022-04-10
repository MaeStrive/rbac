package com.atmae.myrabc.service;

import com.atmae.myrabc.vo.ResultDataVo;

/**
 * @Author: Mae
 * @Date: 2022/2/19
 * @Time: 9:18
 * @Description:
 */
public interface IRoleService {
    /**
     *
     * @param page
     * @param limit
     * @return
     */
    ResultDataVo selectRoleList(Integer page, Integer limit);

    /**
     * 加注解 @Transactional
     */
}
