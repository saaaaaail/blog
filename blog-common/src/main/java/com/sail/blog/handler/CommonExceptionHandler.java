package com.sail.blog.handler;

import com.sail.blog.dto.ResponseDataDTO;
import com.sail.blog.exception.BusinessException;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: blog
 * @description: 公共异常处理类 统一处理
 * @author: sail
 * @create: 2019/05/13 17:00
 */

@Log4j2
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResponseDataDTO BusinessHandleException(BusinessException e){
        log.error("业务异常: code:{},msg:{}",e.getExceptionEnum().getCode(),e.getExceptionEnum().getMsg());
        return ResponseDataDTO.error(e.getExceptionEnum().getMsg(),e.getExceptionEnum().getCode());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseDataDTO AllHandleException(Exception e){
        log.error("系统异常: e",e);
        return ResponseDataDTO.error("系统异常",500);
    }

}
