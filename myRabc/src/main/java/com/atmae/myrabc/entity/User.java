package com.atmae.myrabc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Mae
 * @Date: 2022/2/16
 * @Time: 15:24
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 基本数据类型(int...)存在栈内存中 有默认值:0
     * 包装类 存在堆中 默认值为null
     */
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private Integer age;
    private String address;
}
