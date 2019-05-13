package com.sail.blog.enums;

/**
 * @program: blog
 * @description: enum
 * @author: sail
 * @create: 2019/05/13 15:34
 */

public enum ExceptionEnum {
    /**异常枚举规范
    编码: 3(类型)02(模块)02(实体)01(操作编码)：用户登陆失败!
    描述: 类型 - 框架级系统错误SYS(1), 框架业务扩展错误EXT(2), 业务错误BIZ(3), 第三方错误THIRD(4)
         模块 - 01 Exception 系统 02,web 03
         实体 - 01 Exception 没有00 ,user 02,money 03,order 04
         操作编码 - 不重复的编码(01)

    常量: BIZ(类型)_USER(实体)_LOGIN(操作)_FAILE(结果)：用户登陆失败!
    描述: 操作 - GET(获取)，保存(SAVE)，更新(UPDATE)，删除（DELETE)，登陆(LOGIN)，注册(REGISTER) ...
         结果 - NOT_FOUND(不存在)，失败(FAIL)，ERROR(错误)，INVALID(校验错误) ...

    案例: 1.系统级：SYS_USER_PARAM_EXP（1020201,  "用户请求参数异常！"）
         2.业务级：BIZ_ROLE_SAVE_FAIL(3020101, "用户角色保存失败！")
         3.第三方：THIRD_USER_REAL_AUTH_FAIL(4020001, "用户实名认证失败！")
    */
    ADMIN_USER_NOT_FOUND(405,"用户失效"),
    ADMIN_USER_PASSWORD_ERROR(1000101,"密码错误"),
    ;

    private int code;
    private String msg;

    ExceptionEnum(){}

    ExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
