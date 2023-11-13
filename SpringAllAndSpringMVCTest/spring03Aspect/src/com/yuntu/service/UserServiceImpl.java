package com.yuntu.service;

import com.yuntu.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.service
 * @Author: Shuo
 * @CreateTime: 2023-10-09  10:55
 * @Description:
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;
    @Override
    public void getUserList() {
         userDao.getUserList();
    }
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
