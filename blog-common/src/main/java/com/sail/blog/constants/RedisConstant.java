package com.sail.blog.constants;

import org.apache.commons.lang3.StringUtils;

/**
 * @program: blog
 * @description: redis变量
 * @author: sail
 * @create: 2019/05/12 20:36
 */

public enum RedisConstant {

    /**
     * 系统用户
     */
    ADMIN_USER_LOGIN_TOKEN("EN:ADMINUSER:LOGIN:TOKEN","后台用户登录"),
    ADMIN_USER_LOGIN_TOKEN_TIME_OUT(new Long(30 * 24 * 60 * 60).toString(),"用户登录超时"),
    ;
    private String code;
    private String name;

    RedisConstant(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* 根据code获取name*/
    public static String getNameByCode(String code){
        if (code==null && StringUtils.isEmpty(code)){
            return null;
        }
        RedisConstant[] values = values();
        for (RedisConstant rc:values){
            if (code.equals(rc.getCode())){
                return rc.getName();
            }
        }
        return null;
    }
}
