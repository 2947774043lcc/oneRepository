package com.yuntu.service;

import com.yuntu.entity.User;

import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.service
 * @Author: Shuo
 * @CreateTime: 2023-10-10  15:36
 * @Description:
 * @Version: 1.0
 */
public interface UserService {
    List<User> getUserList(User user);
}
