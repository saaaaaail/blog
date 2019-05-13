package com.sail.blog.controller;

import com.sail.blog.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: blog
 * @description:
 * @author: sail
 * @create: 2019/05/13 13:26
 */

@RestController
public class RedisController {

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("/get")
    public String get(){







        redisUtil.setStr("name","sail",5);
        String Str = redisUtil.getStr("name");

        return Str;
    }

}
