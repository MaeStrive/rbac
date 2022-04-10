package com.atmae.myrabc.controller;

import com.atmae.myrabc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Mae
 * @Date: 2022/2/17
 * @Time: 16:28
 * @Description:
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    IUserService userService;

    @GetMapping("/login")
    public String openLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(String username, String password) {
        boolean b = userService.check(username, password);
        if (b) {
            return "index";
        } else {
            return "login";
        }
    }
}
