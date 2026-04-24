package com.car.api.common.exception;

import com.car.api.common.ReturnMsg;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description: 全局异常处理
 * @author: wuming
 * @create: 2025-03-12 14:47:49
 */
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public ReturnMsg handle(Exception e) {
        e.printStackTrace();
        return ReturnMsg.error(e.getMessage());
    }

}
