package com.yuntu.service;

import com.yuntu.entity.User;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.servise
 * @Author: Shuo
 * @CreateTime: 2023-10-18  08:58
 * @Description:
 * @Version: 1.0
 */
public interface UserService {
    int addUser(User user);
    int delUser(int id);
    /*
    * 事务测试,包含了添加和删除两个也无
    * */
    void tranTest(User user,int id);
}
