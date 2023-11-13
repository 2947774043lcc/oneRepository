package com.yuntu.mapper.user;

import com.yuntu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.dao.user
 * @Author: Shuo
 * @CreateTime: 2023-10-24  14:26
 * @Description:
 * @Version: 1.0
 */
public interface UserMapper {
    /*
    * 通过userCode获取对象用来登录判断
    * */
    User getLoginUser(@Param("userCode") String userCode) throws Exception;

    /*
    * 用户表条目数
    * userName 条目数
    * userRole 角色ID
    * */
    int getUserCode(@Param("userName") String userName,@Param("userRole") int userRole);

    List<User> getUserList(@Param("userName") String userName,@Param("userRole") int userRole,@Param("currentPageNo")int currentPageNo,@Param("pageSize")int pageSize) throws SQLException;

    int add( User user);

    User getUserById(@Param("uid") String uid) throws SQLException;

    int UpdateUser( User user);

    int deleteUserById( Integer uid);

    int updPwd(@Param("user") User user,@Param("newPwd") String newPwd);

    User getCode( String code);
}
