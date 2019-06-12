package com.sail.blog.service.impl;

import com.sail.blog.mapper.AdminUserMapper;
import com.sail.blog.model.AdminUser;
import com.sail.blog.model.User;
import com.sail.blog.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @program: blog
 * @description: 用户service
 * @author: sail
 * @create: 2019/05/14 11:30
 */

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser getByUsernameAndPassword(String account, String password) {
        Example userExample = new Example(AdminUser.class);
        userExample.createCriteria().andEqualTo("account",account)
                .andEqualTo("password",password);

        List<AdminUser> adminUsers = adminUserMapper.selectByExample(userExample);
        if (adminUsers!=null&&adminUsers.size()>0){
            System.out.println(adminUsers.get(0).getAccount());
            return adminUsers.get(0);
        }
        return null;
    }

    @Override
    public void updateAdminUser(AdminUser user) {
        adminUserMapper.updateByPrimaryKey(user);
    }

    @Override
    public int addAdminUser(String userName, String password) {
        AdminUser adminUser = new AdminUser();
        adminUser.setAccount(userName);
        adminUser.setPassword(password);
        return adminUserMapper.insert(adminUser);
    }
}
