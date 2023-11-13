package com.yuntu.dao.user;

import com.yuntu.pojo.Address;
import com.yuntu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: Mybatis01
 * @BelongsPackage: com.yuntu.dao.user
 * @Author: Shuo
 * @CreateTime: 2023-08-29  11:11
 * @Description:
 * @Version: 1.0
 */
public interface UserMapper {
    /*
    * 查询用户表记录数
    * */
    int count();
    /*
    * 查询用户列表
    * */
    List<User> getUserList();

    List<User> getUserListByRoleId(@Param("userRole") Integer roleId);
    /*
    * 根据姓名和密码查询用户
    * */
    List<User> getUserByNameAndPas(User user);

//    @Select(" select * from smbms_user where userName like CONCAT('%',#{userName},'%')")
    @Select(" select * from smbms_user where userName like '%${userName}%'")
    List<User> getUserByLike(@Param("userName") String userName);
    /*
    * 传递多个参数
    *
    * */
    List<User> getUserByLikeTwo(@Param("userName") String userName,@Param("userPassword") String userPassword);
    List<User> getUserByLikeThree(Map<String,String> map);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
    /*
    * 获取指定用户的地址列表
    * */
    List<User> getAddressListByUserId(@Param(value = "userId") Integer userId);

    /**
     * 批量增减用户
     * @param list
     * @return
     */
    int batchInsertUser(List<User> list);
}
