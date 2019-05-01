package com.sail.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @program: blog
 * @description: 后台管理启动类
 * @author: sail
 * @create: 2019/04/29 21:16
 */

@SpringBootApplication
public class BlogManagerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BlogManagerApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BlogManagerApplication.class);
    }
}
