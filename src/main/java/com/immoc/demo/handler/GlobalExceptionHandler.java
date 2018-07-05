package com.immoc.demo.handler;


import com.immoc.demo.entity.Result;
import com.immoc.demo.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    //自定义全局异常
    @ExceptionHandler(value = {DemoException.class, Exception.class})
    @ResponseBody
    private Result exceptionHandler(HttpServletRequest request, Exception e) {
        if (e instanceof DemoException) {
            return ResultUtil.error(100, e.getMessage());
        } else {
            return ResultUtil.error(500, "系统未知异常");
        }

    }

}
