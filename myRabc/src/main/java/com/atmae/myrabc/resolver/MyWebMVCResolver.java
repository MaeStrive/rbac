package com.atmae.myrabc.resolver;

import com.atmae.myrabc.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Mae
 * @Date: 2022/2/18
 * @Time: 10:04
 * @Description:
 */
@Configuration
public class MyWebMVCResolver implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //上岗啦
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/login", "/css/**", "/img/**", "/js/**", "/plugins/**");
    }
}
