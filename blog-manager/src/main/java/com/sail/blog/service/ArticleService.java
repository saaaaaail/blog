package com.sail.blog.service;

import com.github.pagehelper.PageInfo;
import com.sail.blog.mapper.ArticleMapper;
import com.sail.blog.model.Article;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: blog
 * @description:
 * @author: sail
 * @create: 2019/05/20 13:23
 */

public interface ArticleService {
    /**
     * 查询最近的文章
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageInfo<Article> getLatestArticles(String type,Integer pageIndex, Integer pageSize);
}


