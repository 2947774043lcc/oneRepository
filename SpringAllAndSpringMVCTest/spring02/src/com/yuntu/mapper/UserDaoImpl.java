package com.yuntu.mapper;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.dao
 * @Author: Shuo
 * @CreateTime: 2023-09-25  11:17
 * @Description:
 * @Version: 1.0
 */
public class UserDaoImpl implements UserDao{
    @Override
    public void getUserList() {
        System.out.println("select * from user");
    }
}
