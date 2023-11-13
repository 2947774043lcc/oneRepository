package com.yuntu.mapper.user;

import com.yuntu.entity.User;

import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.dao.user
 * @Author: Shuo
 * @CreateTime: 2023-10-10  15:29
 * @Description:
 * @Version: 1.0
 */
public interface UserMapper {
   List<User> getUserList(User user);
}
