package com.yuntu.dao.newUser;

import com.yuntu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: MybatisAllTest
 * @BelongsPackage: com.yuntu.dao.newUser
 * @Author: Shuo
 * @CreateTime: 2023-09-06  08:51
 * @Description:
 * @Version: 1.0
 */
public interface NewUserMapper {
    /*
    * 查询用户列表
    * */
    List<User> getUserList(@Param("userName") String userName, @Param("userRole") Integer userRole);
    int modify(User user);
    int add(User user);
    int add1(@Param("userList") List<User> userList);
//    根据多个角色Id查询对应用户下的信息
    List<User> getUserByRoleId_array(Integer[] roleIds);
    List<User> getUserByRoleId_list(List<Integer> roleList);
    List<User> getUserByRoleId_Map(@Param("roleMap") Map<Integer,Integer> roleMap);

    int deleteUser(@Param("ids") Integer[] ids);

    int addForList(List<User> users);

    /**
     * 批量修改
     * @param list
     * @return
     */
    int updateFforList(List<User> list);

    /**
     * 查询用户列表
     * @param userName
     * @param userRole
     * @param userCode
     * @param createionDate
     * @return
     */
    List<User> getUserList_chose(@Param("userName") String userName, @Param("userRole")Integer userRole, @Param("userCode")String userCode, @Param("createDate")Date createionDate);

    /**
     * 分页提示
     * @param userName
     * @param roleId
     * @param currentPageNo 当前页
     * @param pageSize 页容量
     * @return
     */
    List<User> getUserListByLimit(@Param("userName") String userName,
                                  @Param("roleId")Integer roleId,
                                  @Param("currentPageNo")Integer currentPageNo,
                                  @Param("pageSize") Integer pageSize);

    /**
     * 查询所有
     * @return
     */
    List<User> selectAll();
}
