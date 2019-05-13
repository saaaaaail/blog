package com.sail.blog.test;

import com.sail.blog.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @program: blog
 * @description:
 * @author: sail
 * @create: 2019/05/13 12:52
 */


@SpringBootTest
public class TestDemo {

    @Resource
    RedisUtil redisUtil;

    @Test
    public void test(){
        redisUtil.setStr("name","sail",3);
        System.out.println(redisUtil.getStr("name"));
    }


}
