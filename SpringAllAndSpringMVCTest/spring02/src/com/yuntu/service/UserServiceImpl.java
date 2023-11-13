package com.yuntu.service;

import com.yuntu.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.service
 * @Author: Shuo
 * @CreateTime: 2023-09-25  11:16
 * @Description:
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService{

   @Autowired
    private UserDao userDao;

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "userDao=" + userDao +
                '}';
    }

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUserList() {
        userDao.getUserList();
    }
}
