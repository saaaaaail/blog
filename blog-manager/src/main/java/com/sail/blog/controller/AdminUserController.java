package com.sail.blog.controller;

import com.sail.blog.constants.UserConstant;
import com.sail.blog.dto.ResponseDataDTO;
import com.sail.blog.model.AdminUser;
import com.sail.blog.service.AdminUserService;
import com.sail.blog.util.Md5Util;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @program: blog
 * @description: 用户controller
 * @author: sail
 * @create: 2019/05/14 11:33
 */

@Controller
@Log4j2
@RequestMapping("admin")
public class AdminUserController {

    @Autowired
    AdminUserService adminUserService;

    @RequestMapping("/addUser")
    @ResponseBody
    public ResponseDataDTO addAdminUser(@RequestParam("account")String userName,@RequestParam("password")String password){

        String pass = Md5Util.md5(UserConstant.USER_PASSWORD_PREFIX,password);

        if (adminUserService.addAdminUser(userName,pass)>0){
            return ResponseDataDTO.success();
        }else{
            return ResponseDataDTO.error();
        }
    }
}
