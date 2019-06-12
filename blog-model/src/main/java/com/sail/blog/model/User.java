package com.sail.blog.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @program: User
 * @description:
 * @author: sail
 * @create: 2019/5/4 21:20
 */

@Data
@Table(name = "user")
@ApiModel(value = "user",description = "后台用户")
public class User {

    @Id
    @Column(name = "id")
    @ApiModelProperty(value = "id",name = "id")
    private Long id;

    @ApiModelProperty(value = "昵称",name = "nickName")
    private String nickName;

    @ApiModelProperty(value = "用户名",name = "userName")
    private String userName;

    @ApiModelProperty(value = "密码",name = "password")
    private String userPass;

    @ApiModelProperty(value = "用户链接",name = "url")
    private String url;

    @ApiModelProperty(value = "手机号",name = "tel")
    private String tel;

    @ApiModelProperty(value = "邮箱",name = "mail")
    private String mail;

    /**
     * 注册时间
     */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Date createTime;
    /**
     * 用户组
     */
    @ApiModelProperty(value = "用户组", name = "groupName")
    private String groupName;
}
