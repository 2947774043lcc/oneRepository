package com.yuntu.dao.test;

import com.yuntu.dao.address.AddressMapper;
import com.yuntu.dao.bill.BillMapper;
import com.yuntu.dao.provider.ProviderMapper;
import com.yuntu.dao.role.RoleMapper;
import com.yuntu.dao.user.UserMapper;
import com.yuntu.pojo.*;
import com.yuntu.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @BelongsProject: MybatisAllTest
 * @BelongsPackage: com.yuntu.dao.user
 * @Author: Shuo
 * @CreateTime: 2023-08-30  11:08
 * @Description:
 * @Version: 1.0
 */
public class UserTest {
    private Logger logger = Logger.getLogger(UserTest.class);
    @org.junit.Test
    public void getUserList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<User> list = sqlSession.getMapper(UserMapper.class).getUserList();
       list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }

    @org.junit.Test
    public void addUserTest(){
        try {
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            User user = new User();
            user.setUserCode("test001");
            user.setUserName("测试用户");
            user.setUserPassword("123456");
            user.setAddress("地址不详");
            user.setGender(1);
            user.setPhone("12312312313123");
            user.setUserRole(1);
            user.setCreatedBy(1);
            user.setCreationDate(new Date());
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("2023-09-04");
            user.setBirthday(birthday);
            int count = sqlSession.getMapper(UserMapper.class).addUser(user);
            sqlSession.commit();//提交
            System.out.println(count);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            MybatisUtils.closeSqlSession();
        }
    }
    @org.junit.Test
    public void updateUserTest(){
        try {
//            Scanner scanner = new Scanner(System.in);
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            User user = new User();
            user.setId(16);
            user.setUserCode("test001");
            user.setUserName("周");
            user.setUserPassword("123456");
            user.setAddress("地址不详");
            user.setGender(1);
            user.setPhone("12312312313123");
            user.setUserRole(1);
            user.setCreatedBy(1);
            user.setCreationDate(new Date());
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("2023-07-06");
            user.setBirthday(birthday);
            int count = sqlSession.getMapper(UserMapper.class).updateUser(user);
            sqlSession.commit();//提交
            System.out.println(count);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            MybatisUtils.closeSqlSession();
        }
    }
    @org.junit.Test
    public void deleteUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int count = sqlSession.getMapper(UserMapper.class).deleteUser(15);
        sqlSession.commit();//提交
        System.out.println(count);
        MybatisUtils.closeSqlSession();
    }
    @Test
    public void getUserListByRoleIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<User> list = sqlSession.getMapper(UserMapper.class).getUserListByRoleId(1);
        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }
    @Test
    public void getUserByLikeTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<User> list = sqlSession.getMapper(UserMapper.class).getUserByLike("李明");
        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }
    @Test
    public void getAddressListByUserIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<User> list = sqlSession.getMapper(UserMapper.class).getAddressListByUserId(1);
        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }
}
