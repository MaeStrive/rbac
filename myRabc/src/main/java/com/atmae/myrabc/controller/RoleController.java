package com.atmae.myrabc.controller;


import com.atmae.myrabc.service.IRoleService;
import com.atmae.myrabc.vo.ResultDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Mae
 * @Date: 2022/2/19
 * @Time: 8:51
 * @Description:
 */
@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private IRoleService roleService;


    /**
     * 打开用户主页面
     */
    @GetMapping("/index")
    public String openPage() {
        return "role";
    }

    @GetMapping("/list")
    @ResponseBody
    public ResultDataVo selectRoleList(Integer page, Integer limit) {
        return roleService.selectRoleList(page, limit);
    }

}
