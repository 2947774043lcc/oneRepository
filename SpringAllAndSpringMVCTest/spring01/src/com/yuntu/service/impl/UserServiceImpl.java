package com.yuntu.service.impl;

import com.yuntu.mapper.UserDao;
import com.yuntu.service.UserService;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.service.impl
 * @Author: Shuo
 * @CreateTime: 2023-09-20  09:04
 * @Description:
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {
//     private UserDao userDao  =  new UserDaoImpl();
//     private UserDao userDao2  =  new UserDao2Impl();
    private UserDao userDao;
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    @Override
    public void getUserList() {
      userDao.getUserList();
    }
}
