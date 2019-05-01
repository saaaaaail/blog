package com.sail.blog.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @program: blog
 * @description: druid连接池配置
 * @author: sail
 * @create: 2019/04/29 20:21
 */

@Configuration
public class DruidConfig {

    @Autowired
    private DruidDataSourceDto druidDataSource;

    @Autowired
    private WallFilter wallFilter;

    @Bean //声明为Bean实例
    @Primary  //在同样的DataSource中，优先使用被标注的
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(druidDataSource.getUrl());
        dataSource.setUsername(druidDataSource.getUsername());
        dataSource.setPassword(druidDataSource.getPassword());
        dataSource.setDriverClassName(druidDataSource.getDriverClassName());

        //configuration
        dataSource.setInitialSize(druidDataSource.getInitialSize());
        dataSource.setMaxActive(druidDataSource.getMaxActive());
        dataSource.setMaxWait(druidDataSource.getMaxWait());
        dataSource.setMinIdle(druidDataSource.getMinIdle());
        dataSource.setTimeBetweenEvictionRunsMillis(druidDataSource.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(druidDataSource.getMinEvictableIdleTimeMillis());
        dataSource.setValidationQuery(druidDataSource.getValidationQuery());
        dataSource.setTestWhileIdle(druidDataSource.isTestWhileIdle());
        dataSource.setTestOnBorrow(druidDataSource.isTestOnBorrow());
        dataSource.setTestOnReturn(druidDataSource.isTestOnReturn());
        dataSource.setPoolPreparedStatements(druidDataSource.isPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(druidDataSource.getMaxPoolPreparedStatementPerConnectionSize());
        dataSource.setUseGlobalDataSourceStat(druidDataSource.isUseGlobalDataSourceStat());
        dataSource.setRemoveAbandoned(druidDataSource.isRemoveAbandoned());
        dataSource.setRemoveAbandonedTimeout(druidDataSource.getRemoveAbandonedTimeout());
        dataSource.setConnectionProperties(druidDataSource.getConnectionProperties());
        try {
            dataSource.setFilters(druidDataSource.getFilters());
        } catch (Exception e) {
            System.err.println("druid configuration initialization filter: " + e);
        }
        return dataSource;
    }

    @Bean(name = "wallConfig")
    public WallConfig wallConfig(){
        WallConfig wallConfig = new WallConfig();
        wallConfig.setMultiStatementAllow(true);
        return wallConfig;
    }

    @Bean(name = "wallFilter")
    @DependsOn("wallConfig")
    public WallFilter wallFilter(WallConfig wallConfig){
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig);
        return wallFilter;
    }

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // IP白名单
        servletRegistrationBean.addInitParameter("allow", "192.168.1.101,127.0.0.1");
        // IP黑名单(共同存在时，deny优先于allow)
        servletRegistrationBean.addInitParameter("deny", "192.168.1.100");
        //控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
