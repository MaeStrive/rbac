package com.atmae.myrabc.controller;

import com.atmae.myrabc.entity.User;
import com.atmae.myrabc.service.IUserService;
import com.atmae.myrabc.vo.ResultDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Mae
 * @Date: 2022/2/16
 * @Time: 10:20
 * @Description: 用户控制层
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 打开用户主页面
     */
    @GetMapping("/index")
    public String openPage() {
        return "user";
    }


    /**
     * 查询用户列表数据
     * ResponseBody：将结果转为数据直接返回给浏览器，而不去找对应的模板
     *
     * @return 用户列表数据
     */
    @GetMapping("/list")
    @ResponseBody
    public ResultDataVo selectUsers(Integer page, Integer limit,String keyword) {
        System.out.println(keyword);
        return userService.selectUserList(page,limit,keyword);
    }

    @PostMapping("/save")
    @ResponseBody
    public void saveUser(User user) {
        userService.saveUser(user);
    }

    @PostMapping("/del")
    @ResponseBody
    public void delUser(Integer id) {
        userService.delUser(id);
    }

    @GetMapping("/info")
    @ResponseBody
    public User selectById(Integer id) {
        return userService.selectById(id);
    }
}
