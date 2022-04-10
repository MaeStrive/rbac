package com.atmae.myrabc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Mae
 * @Date: 2022/2/19
 * @Time: 17:52
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private String title;
    private String content;
    private String to;
}
