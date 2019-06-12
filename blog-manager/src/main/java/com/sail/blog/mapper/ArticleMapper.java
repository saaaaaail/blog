package com.sail.blog.mapper;

import com.sail.blog.base.BaseMapper;
import com.sail.blog.model.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @program: blog
 * @description:
 * @author: sail
 * @create: 2019/05/20 13:21
 */

@Mapper
@Component
public interface ArticleMapper extends BaseMapper<Article> {
}
