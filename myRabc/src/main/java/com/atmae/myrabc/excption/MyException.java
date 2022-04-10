package com.atmae.myrabc.excption;

/**
 * @Author: Mae
 * @Date: 2022/2/19
 * @Time: 9:44
 * @Description:
 */
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String msg;

    public MyException() {
    }

    public MyException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
