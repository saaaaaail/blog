package com.sail.blog.mapper;

import com.sail.blog.base.BaseMapper;
import com.sail.blog.model.AdminUser;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @program: blog
 * @description:
 * @author: sail
 * @create: 2019/05/14 11:21
 */

@Mapper
@Component
public interface AdminUserMapper extends BaseMapper<AdminUser> {

}
