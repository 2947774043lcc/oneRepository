package com.yuntu.service.impl;

import com.yuntu.entity.User;
import com.yuntu.mapper.UserMapper;
import com.yuntu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.servise.impl
 * @Author: Shuo
 * @CreateTime: 2023-10-18  08:58
 * @Description:
 * @Version: 1.0
 */
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int delUser(int id) {
        return userMapper.delUser(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void tranTest(User user, int id) {
        addUser(user);
        delUser(id);
    }
}
