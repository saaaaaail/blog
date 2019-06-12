package com.sail.blog.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @program: blog
 * @description: 管理员
 * @author: sail
 * @create: 2019/05/14 11:58
 */

@Table(name = "admin_user")
@Data
@ApiModel(value = "AdminUser",description = "管理员")
public class AdminUser {

    @Id
    @ApiModelProperty(value = "id",name = "id")
    private Long id;

    @ApiModelProperty(value = "姓名",name = "name")
    private String name;

    @ApiModelProperty(value = "账户名",name = "account")
    private String account;

    @ApiModelProperty(value = "密码",name = "password")
    private String password;

    @ApiModelProperty(value = "创建时间",name = "createTime")
    private Date createTime;
}
