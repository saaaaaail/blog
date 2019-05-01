package com.sail.blog.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: blog
 * @description: Mybatis配置类
 * @author: sail
 * @create: 2019/05/01 21:05
 */

@Configuration
@MapperScan(basePackages = "com.sail.blog.mapper",
        sqlSessionFactoryRef = "sqlSessionFactory",
        annotationClass = Mapper.class)
public class MybatisConfig {
}
