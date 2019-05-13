package com.sail.blog.exception;

import com.sail.blog.enums.ExceptionEnum;

/**
 * @program: blog
 * @description: 业务代码自定义异常类
 * @author: sail
 * @create: 2019/05/13 16:47
 */

public class BusinessException extends RuntimeException{

    private ExceptionEnum exceptionEnum;

    public BusinessException(){}

    public BusinessException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public void setExceptionEnum(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }
}
