package com.sail.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sail.blog.constants.RedisConstant;
import com.sail.blog.constants.UserConstant;
import com.sail.blog.dto.ResponseDataDTO;
import com.sail.blog.model.AdminUser;
import com.sail.blog.service.AdminUserService;
import com.sail.blog.util.Md5Util;
import com.sail.blog.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: blog
 * @description: 登录controller
 * @author: sail
 * @create: 2019/05/14 11:18
 */

@Controller
@Log4j2
@Api(tags = "登录相关")
public class LoginController {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation("用户登录")
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseDataDTO<String> loginIn(@ModelAttribute AdminUser user, HttpServletRequest request){
        log.info(user.getAccount());
        log.info(user.getPassword());
        String pass = Md5Util.md5(UserConstant.USER_PASSWORD_PREFIX,user.getPassword());
        user = adminUserService.getByUsernameAndPassword(user.getAccount(),pass);
        if (user!=null){
            String token = Md5Util.md5(UserConstant.USER_TOKEN_PREFIX,user.getId().toString());
            redisUtil.setStr(RedisConstant.ADMIN_USER_LOGIN_TOKEN.getCode()+":"+token,
                    JSON.toJSONString(user),
                    Long.parseLong(RedisConstant.ADMIN_USER_LOGIN_TOKEN_TIME_OUT.getCode()));
            return ResponseDataDTO.success(token);
        }
        return ResponseDataDTO.error("账号与密码不匹配");
    }

    @ApiOperation("用户登出")
    @RequestMapping(value = "/loginOut",method = RequestMethod.POST)
    public ResponseDataDTO<String> loginOut(@ModelAttribute AdminUser user, HttpServletRequest request){

        return null;
    }


}
