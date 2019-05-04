package com.sail.blog.model;

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
public class Comment {

    @Id
    @Column(name = "id")
    private Long id;
    /**
     * 评论回复的内容id
     */
    @Column(name = "entity_id")
    private Long entityId;
    /**
     * 评论回复的类型
     */
    private String entityType;
    /**
     * 发出评论的用户id
     */
    private Long userId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 实体类型
     */
    private String type;
    /**
     * 评论状态
     */
    private String status;

    private Date createTime;

    private Date updateTime;
}
