package com.sail.blog.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @program: Comment
 * @description: 评论类
 * @author: sail
 * @create: 2019/5/4 20:45
 */

@Data
@Table(name = "comment")
@ApiModel(value = "Comment",description = "评论")
public class Comment {

    @Id
    @Column(name = "id")
    private Long id;
    /**
     * 评论回复的内容id，这个内容可以是文章id，可以是评论id
     */
    @Column(name = "entity_id")
    private Long entityId;
    /**
     * 评论回复的实体的类型，可以是文章，可以是评论
     */
    private String entityType;
    /**
     * 该评论所属的用户id
     */
    private Long userId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 实体类型 COMMENT 1
     */
    private Integer type;
    /**
     * 评论状态 发布，撤销  0/1
     */
    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String createName;

    private String updateName;

    private Integer isDeleted;

    private Integer isOnline;
}
