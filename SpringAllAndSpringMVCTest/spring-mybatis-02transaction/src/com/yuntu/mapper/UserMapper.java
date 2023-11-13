package com.yuntu.mapper;

import com.yuntu.entity.User;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.mapper
 * @Author: Shuo
 * @CreateTime: 2023-10-18  08:53
 * @Description:
 * @Version: 1.0
 */
public interface UserMapper {
    int addUser(User user);
    int delUser(int id);
}
