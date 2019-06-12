package com.sail.blog.controller;

import com.github.pagehelper.PageInfo;
import com.sail.blog.dto.ResponseDataDTO;
import com.sail.blog.model.Article;
import com.sail.blog.service.ArticleService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: blog
 * @description:
 * @author: sail
 * @create: 2019/05/20 14:37
 */

@Controller
@Log4j2
@Api("文章相关")
@RequestMapping("/article")
public class ArticleController  {

    @Autowired
    ArticleService articleService;

    @ResponseBody
    @RequestMapping(value = "/getArticles",method = RequestMethod.POST)
    public ResponseDataDTO<PageInfo<Article>> getLatestArticle(@RequestParam("pageIndex") Integer pageIndex,
                                                               @RequestParam("pageSize") Integer pageSize,
                                                               @RequestParam("type") String type){
        return ResponseDataDTO.success(articleService.getLatestArticles(type,pageIndex,pageSize));
    }
}
