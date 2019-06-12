package com.sail.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sail.blog.mapper.AdminUserMapper;
import com.sail.blog.mapper.ArticleMapper;
import com.sail.blog.model.Article;
import com.sail.blog.service.ArticleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: blog
 * @description:
 * @author: sail
 * @create: 2019/05/20 13:51
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public PageInfo<Article> getLatestArticles(String type,Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        Example articleExample = new Example(Article.class);
        articleExample.orderBy("id").desc();
        Example.Criteria criteria = articleExample.createCriteria();
        if (type.equals("all")){

        }else if (!StringUtils.isEmpty(type)){
            criteria.andEqualTo("type",type);
        }
        List<Article> articles = articleMapper.selectByExample(articleExample);
        return new PageInfo<>(articles);

    }
}
