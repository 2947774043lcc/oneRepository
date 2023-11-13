package com.yuntu.mapper;

import org.springframework.stereotype.Component;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.dao
 * @Author: Shuo
 * @CreateTime: 2023-10-09  10:54
 * @Description:
 * @Version: 1.0
 */
@Component
public class UserDaoImpl implements UserDao{
    @Override
    public void getUserList() {
        System.out.println("select * from user");
    }
}
