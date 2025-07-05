package com.company.oa.common;

import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R<Void> handleException(Exception ex) {
        // 可根据不同异常类型细化
        return R.error(ex.getMessage());
    }
}