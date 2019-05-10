package com.sail.blog.model;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

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
public class User {

    @Id
    @Column(name = "id")
    private Long id;

    private String nickName;

    private String userName;

    private String userPass;

    private String url;

    private String tel;

    private String mail;

    /**
     * 注册时间
     */
    private Date createTime;
    /**
     * 用户组
     */
    private String groupName;
}
