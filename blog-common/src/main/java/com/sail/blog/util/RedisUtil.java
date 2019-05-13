package com.sail.blog.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @program: blog
 * @description: redis工具类
 * @author: sail
 * @create: 2019/05/13 10:31
 */

@Log4j2
@Component
public class RedisUtil {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Autowired
    ValueOperations<String,String> strOperations;

    /**
     * 设置Str缓存
     *
     * @param key
     * @param val
     * @param expire
     */
    public void setStr(String key,String val,long expire){
        strOperations.set(key,val,expire, TimeUnit.SECONDS);
    }

    /**
     * 根据指定key获取String
     *
     * @param key
     * @return
     */
    public String getStr(String key) {
        return strOperations.get(key);
    }

    /**
     * 删除指定key
     *
     * @param key
     */
    public void del(String key){
        stringRedisTemplate.delete(key);
    }

}
