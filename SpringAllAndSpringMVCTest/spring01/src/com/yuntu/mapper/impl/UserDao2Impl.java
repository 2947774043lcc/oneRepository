package com.yuntu.mapper.impl;

import com.yuntu.mapper.UserDao;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.dao.impl
 * @Author: Shuo
 * @CreateTime: 2023-09-20  09:11
 * @Description:
 * @Version: 1.0
 */
public class UserDao2Impl implements UserDao {
    @Override
    public void getUserList() {
        System.out.println("select * from newUser");
    }
}
