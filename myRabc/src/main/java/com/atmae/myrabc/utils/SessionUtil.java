package com.atmae.myrabc.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.atmae.myrabc.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



//操作请求session的工具类
public class SessionUtil {
	
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	}

	// 获取当前的Session
	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	public static User getCurrentUser() {
		Object obj = getSession().getAttribute("currentUser");
		if (obj != null) {
			return (User) obj;
		}
		return null;
	}

}
