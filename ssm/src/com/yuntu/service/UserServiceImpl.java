package com.yuntu.service;

import com.yuntu.mapper.user.UserMapper;
import com.yuntu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.service
 * @Author: Shuo
 * @CreateTime: 2023-10-24  14:36
 * @Description:
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String userCode, String password) throws Exception {
        User user = null;
        user =userMapper.getLoginUser(userCode);

        //密码匹配
        if (null != user){
            if (!user.getUserPassword().equals(password)){
                user = null;
            }
        }
        return user;
    }

    @Override
    public int getUserCode(String userName, int userRole) {
        return userMapper.getUserCode(userName,userRole);
    }

    @Override
    public List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize) throws SQLException {
        currentPageNo = (currentPageNo-1)*pageSize;
        List<User> list = userMapper.getUserList(userName, userRole, currentPageNo, pageSize);
        return list;
    }

    @Override
    public boolean add(User user) {
        boolean flag = false;
        int add = userMapper.add(user);
        if (add!=0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public User getUserById(String uid) throws SQLException {
        return userMapper.getUserById(uid);
    }

    @Override
    public boolean UpdateUser(User user) {
        if (userMapper.UpdateUser(user)>0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUserById(Integer uid) {
        if (userMapper.deleteUserById(uid)>0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updPwd(User user,String newPwd) {
        if (userMapper.updPwd(user,newPwd)>0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean getCode(String code) {
        if (userMapper.getCode(code)!=null){
            return true;
        }
        return false;
    }
}
