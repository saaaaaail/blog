package com.sail.blog.base;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: blog
 * @description:
 * @author: sail
 * @create: 2019/05/01 21:44
 */

@Component
public class BaseVO {
    private Map<String,Object> map = new HashMap<>();

    public Object get(String key){
        return map.get(key);
    }

    public void set(String key,Object val){
        map.put(key,val);
    }
}
