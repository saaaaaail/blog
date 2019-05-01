package com.sail.blog.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @program: blog
 * @description: druid数据源
 * @author: sail
 * @create: 2019/04/29 20:24
 */

@Configuration
@Data
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidDataSourceDto {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private String filters;
    private int maxActive;
    private int initialSize;
    private int maxWait;
    private int minIdle;
    private long timeBetweenEvictionRunsMillis;
    private long minEvictableIdleTimeMillis;
    private int removeAbandonedTimeout;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    private boolean useGlobalDataSourceStat;
    private boolean removeAbandoned;
    private int removeAbandTimeout;
    private String connectionProperties;

}
