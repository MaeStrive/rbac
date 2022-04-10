package com.atmae.myrabc.excption;

import com.atmae.myrabc.vo.ResultDataVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Mae
 * @Date: 2022/2/19
 * @Time: 9:48
 * @Description: 统一异常处理
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    public ResponseEntity<ResultDataVo> exception1(MyException e) {
        ResultDataVo vo = new ResultDataVo();
        vo.setMsg(e.getMsg());
        return new ResponseEntity<ResultDataVo>(vo, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultDataVo exception2(MyException e) {
        ResultDataVo vo = new ResultDataVo();
        vo.setMsg("内部处理错误，请联系管理员");
        return vo;
    }
}

