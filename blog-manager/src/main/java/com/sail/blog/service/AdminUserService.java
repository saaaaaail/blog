package com.sail.blog.service;

import com.sail.blog.model.AdminUser;
import com.sail.blog.model.User;

/**
 * @program: blog
 * @description:
 * @author: sail
 * @create: 2019/05/14 11:18
 */

public interface AdminUserService {
    /**
     * 账号密码获取后台用户
     * @param userName
     * @param password
     * @return
     */
    AdminUser getByUsernameAndPassword(String userName, String password);

    /**
     * 修改用户
     * @param user
     */
    void updateAdminUser(AdminUser user);


    int addAdminUser(String userName,String password);
}
