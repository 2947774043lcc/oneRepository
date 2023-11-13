package com.yuntu.service.impl;

import com.yuntu.mapper.user.UserMapper;
import com.yuntu.entity.User;
import com.yuntu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.service.impl
 * @Author: Shuo
 * @CreateTime: 2023-10-10  15:37
 * @Description:
 * @Version: 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getUserList(User user) {
        return userMapper.getUserList(user);
    }
}
