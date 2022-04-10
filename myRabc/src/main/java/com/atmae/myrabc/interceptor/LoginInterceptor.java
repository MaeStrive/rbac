package com.atmae.myrabc.interceptor;

import com.atmae.myrabc.utils.SessionUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Mae
 * @Date: 2022/2/18
 * @Time: 9:38
 * @Description: 专门负责管理是不是已经登录的拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean isLogin = SessionUtil.getSession().getAttribute("current") != null;
        if (isLogin) {
            return true;
        } else {
            response.sendRedirect("/login");
            return false;
        }
    }
}
