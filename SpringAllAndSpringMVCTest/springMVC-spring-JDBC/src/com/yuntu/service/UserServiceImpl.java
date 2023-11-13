package com.yuntu.service;

import com.yuntu.mapper.user.UserDao;
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
    private UserDao userDao;
    @Override
    public User login(String userCode, String password) throws Exception {
        User user = null;
        user =userDao.getLoginUser(userCode);

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
        return userDao.getUserCode(userName,userRole);
    }

    @Override
    public List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize) throws SQLException {
        currentPageNo = (currentPageNo-1)*pageSize;
        List<User> list = userDao.getUserList(userName, userRole, currentPageNo, pageSize);
        return list;
    }

    @Override
    public boolean add(User user) {
        boolean flag = false;
        int add = userDao.add(user);
        if (add!=0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public User getUserById(String uid) throws SQLException {
        return userDao.getUserById(uid);
    }

    @Override
    public boolean UpdateUser(User user) {
        if (userDao.UpdateUser(user)>0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUserById(Integer uid) {
        if (userDao.deleteUserById(uid)>0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updPwd(User user,String newPwd) {
        if (userDao.updPwd(user,newPwd)>0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean getCode(String code) {
        if (userDao.getCode(code)!=null){
            return true;
        }
        return false;
    }
}
