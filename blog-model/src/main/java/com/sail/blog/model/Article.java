package com.sail.blog.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @program: blog
 * @description: 文章实体类
 * @author: sail
 * @create: 2019/05/01 21:33
 */

@Data
@Table(name = "article")
public class Article {
    @Id
    @Column(name = "id")
    private Long id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 创建用户id
     */
    private Long userId;
    /**
     * 封面
     */
    private String coverImage;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 是否置顶
     */
    private Boolean top;
    /**
     * 类型
     */
    private String type;
    /**
     * 文章状态/草稿/发布
     */
    private String status;

    private Boolean recommended;
    /**
     * 文章目录所属
     */
    private Boolean category;
    /**
     * 文章描述
     */
    private String description;
    /**
     * 关键词
     */
    private String keywords;
    /**
     * 是否允许评论
     */
    private Boolean comment;
    /**
     * 浏览量
     */
    @Transient
    private Integer lookCount;
    /**
     * 评论量
     */
    @Transient
    private Integer commentCount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新文章时间
     */
    private Date updateTime;
}
