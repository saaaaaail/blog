package com.sail.blog.base;

import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: blog
 * @description: 基本DO
 * @author: sail
 * @create: 2019/05/01 21:44
 */

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class BaseDO implements Serializable {
    private static final long serialVersionUID = 5088697673359856350L;

    @Id
    private long id;
    private Date createTime;
    private Date updateTime;
}
