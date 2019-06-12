package com.sail.blog.util;

import com.alibaba.fastjson.JSON;
import com.sail.blog.constants.RedisConstant;
import com.sail.blog.enums.ExceptionEnum;
import com.sail.blog.exception.BusinessException;
import com.sail.blog.model.AdminUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: blog
 * @description:
 * @author: sail
 * @create: 2019/05/14 16:28
 */

@Component
public class CommonUtil {

    @Autowired
    private RedisUtil redisUtil;

    public AdminUser getUserBySession(HttpServletRequest request){
        String token = request.getHeader("token");
        if (!StringUtils.isEmpty(token)){
            String jsonUser = redisUtil.getStr(RedisConstant.ADMIN_USER_LOGIN_TOKEN.getCode()+":"+token);
            if (!StringUtils.isEmpty(jsonUser)){
                return JSON.parseObject(jsonUser,AdminUser.class);
            }else {
                throw new BusinessException(ExceptionEnum.ADMIN_USER_NOT_FOUND);//用户未找到
            }
        }else {
            throw new BusinessException(ExceptionEnum.ADMIN_USER_NOT_FOUND);
        }
    }
}
