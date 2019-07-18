package com.sail.blog.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "Article",description = "文章")
public class Article {
    @Id
    @Column(name = "id")
    @ApiModelProperty(value = "id", name = "id")
    private Long id;
    /**
     * 文章标题
     */
    @ApiModelProperty(value = "标题", name = "title")
    private String title;
    /**
     * 创建用户id
     */
    @ApiModelProperty(value = "userId", name = "用户id")
    private Long userId;
    /**
     * 封面
     */
    @ApiModelProperty(value = "封面", name = "coverImage")
    private String coverImage;
    /**
     * 文章内容
     */
    @ApiModelProperty(value = "内容", name = "content")
    private String content;
    /**
     * 是否置顶
     */
    @ApiModelProperty(value = "置顶", name =  "top")
    private Integer top;
    /**
     * 实体类型 ARTICLE 0
     */
    @ApiModelProperty(value = "实体类型", name ="type" )
    private Integer type;
    /**
     * 文章状态/草稿/发布 0,1,2
     */
    @ApiModelProperty(value = "文章状态", name = "status")
    private Integer status;

    private Integer isRecommended;
    /**
     * 文章目录所属
     */
    @ApiModelProperty(value = "文章目录", name = "category")
    private String category;
    /**
     * 文章描述
     */
    @ApiModelProperty(value =  "文章描述", name ="description")
    private String description;
    /**
     * 关键词
     */
    @ApiModelProperty(value ="关键词", name =  "keywords")
    private String keywords;
    /**
     * 是否允许评论
     */
    @ApiModelProperty(value = "是否开启评论", name = "comment")
    private Integer isComment;
    /**
     * 浏览量
     */
    @Transient
    @ApiModelProperty(value = "浏览量", name = "lookCount")
    private Integer lookCount;
    /**
     * 评论量
     */
    @Transient
    @ApiModelProperty(value = "评论量", name = "commentCount")
    private Integer commentCount;
    /**
     * 创建时间
     */
    @ApiModelProperty(value =  "文章创建时间", name ="createTime")
    private Date createTime;
    /**
     * 更新文章时间
     */
    @ApiModelProperty(value = "文章更新时间", name = "updateTime")
    private Date updateTime;

    private String createName;

    private String updateName;

    private Integer isDeleted;

    private Integer isOnline;
}
