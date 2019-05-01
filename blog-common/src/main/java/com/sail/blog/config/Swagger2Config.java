package com.sail.blog.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @program: blog
 * @description: swagger配置
 * @author: sail
 * @create: 2019/05/01 14:50
 */

@Configuration
public class Swagger2Config {

    /**
     * Swagger2配置类
     * 在与spring boot集成时，放在与Application.java同级的目录下。
     * 通过@Configuration注解，让Spring来加载该类配置。
     * 再通过@EnableSwagger2注解来启用Swagger2。
     */

    @Bean
    public Docket platformApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        tokenPar.defaultValue("6e1ef1e720a207c326adbb91389c9ee2");
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.any())
                .paths(regex("^.*(?<!error)$"))
                .build()
                .globalOperationParameters(pars);

    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API文档")
                .description("默认登录为id为1的用户")
                .contact(new Contact(" ", "", " "))
                .license(" ")
                .licenseUrl("http://www.baidu.com")
                .version("2.0").build();
    }
}
