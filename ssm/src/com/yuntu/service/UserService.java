package com.yuntu.service;

import com.yuntu.pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.service
 * @Author: Shuo
 * @CreateTime: 2023-10-24  14:33
 * @Description:
 * @Version: 1.0
 */
public interface UserService {
    /*
    用户登录
    */
    User login(String userCode,String password) throws Exception;

    int getUserCode(String userName,int userRole);

    List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize) throws SQLException;

    boolean add(User user);

    User getUserById(String uid) throws SQLException;

    boolean UpdateUser(User user);

    boolean deleteUserById(Integer uid);

    boolean updPwd(User user,String newPwd);

    boolean getCode(String code);
}
