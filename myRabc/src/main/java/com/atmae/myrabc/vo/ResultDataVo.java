package com.atmae.myrabc.vo;
import lombok.Data;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2022/2/16
 * @Time: 13:55
 * @Description:
 */
public class ResultDataVo {
    private int code;
    private String msg;
    private long count;
    private List<?> data;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
