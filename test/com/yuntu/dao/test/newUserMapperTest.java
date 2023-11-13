package com.yuntu.dao.test;

import com.yuntu.dao.newUser.NewUserMapper;
import com.yuntu.pojo.User;
import com.yuntu.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @BelongsProject: MybatisAllTest
 * @BelongsPackage: com.yuntu.dao.test
 * @Author: Shuo
 * @CreateTime: 2023-09-06  08:53
 * @Description:
 * @Version: 1.0
 */
public class newUserMapperTest {
    private Logger logger = Logger.getLogger(newUserMapperTest.class);

    @Test
    public void testGetUserList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<User> list = sqlSession.getMapper(NewUserMapper.class).getUserList("李", null);
        MybatisUtils.closeSqlSession();
        list.forEach(System.out::println);
    }

    @Test
    public void modifyTest(){
        try {
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            User user = new User();
            user.setId(16);
            user.setUserCode("test002");
            user.setUserName("测试用户");
            user.setUserPassword("123456");
            user.setAddress("地址不详");
            user.setGender(1);
            user.setPhone("12312312313123");
            user.setUserRole(1);
            user.setCreatedBy(1);
            user.setCreationDate(new Date());
            Date birthday = null;
            birthday = new SimpleDateFormat("yyyy-MM-dd").parse("2023-09-04");
            user.setBirthday(birthday);
            int modify = sqlSession.getMapper(NewUserMapper.class).modify(user);
            sqlSession.commit();
            System.out.println(modify);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }finally {
            MybatisUtils.closeSqlSession();
        }
    }
    @Test
    public void addTest(){
        try {
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            User user = new User();
            user.setUserCode("test003");
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
            int count = sqlSession.getMapper(NewUserMapper.class).add(user);
            sqlSession.commit();//提交
            System.out.println(count);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            MybatisUtils.closeSqlSession();
        }
    }
    @Test
    public void add1Test(){
        try {
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            User user = new User();
            user.setUserCode("test008");
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
            User user1 = new User();
            user1.setUserCode("test004");
            user1.setUserName("测试用户");
            user1.setUserPassword("123456");
            user1.setAddress("地址不详");
            user1.setGender(1);
            user1.setPhone("12312312313123");
            user1.setUserRole(1);
            user1.setCreatedBy(1);
            user1.setCreationDate(new Date());
            Date birthday1 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-09-04");
            user1.setBirthday(birthday1);
            List<User> list = new ArrayList<>();
            list.add(user);
            list.add(user1);
            int count = sqlSession.getMapper(NewUserMapper.class).add1(list);
            sqlSession.commit();//提交
            System.out.println(count);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            MybatisUtils.closeSqlSession();
        }
    }


    @Test
    public void getUserByRoleId_arrayTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Integer[] ids={1,2,3};
        List<User> userByRoleIdArray = sqlSession.getMapper(NewUserMapper.class).getUserByRoleId_array(ids);
        userByRoleIdArray.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }
    @Test
    public void getUserByRoleId_MapTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        List<User> userByRoleIdArray = sqlSession.getMapper(NewUserMapper.class).getUserByRoleId_Map(map);
        userByRoleIdArray.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }
    @Test
    public void deleteUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Integer[] ids={20,21,22};
        int count = sqlSession.getMapper(NewUserMapper.class).deleteUser(ids);
        System.out.println(count);
        sqlSession.commit();
        MybatisUtils.closeSqlSession();
    }

    @Test
    public void addForListTest(){
        try {
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            User user = new User();
            user.setUserCode("test008");
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
            User user1 = new User();
            user1.setUserCode("test004");
            user1.setUserName("测试用户");
            user1.setUserPassword("123456");
            user1.setAddress("地址不详");
            user1.setGender(1);
            user1.setPhone("12312312313123");
            user1.setUserRole(1);
            user1.setCreatedBy(1);
            user1.setCreationDate(new Date());
            Date birthday1 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-09-04");
            user1.setBirthday(birthday1);
            List<User> list = new ArrayList<>();
            list.add(user);
            list.add(user1);
            int count = sqlSession.getMapper(NewUserMapper.class).addForList(list);
            sqlSession.commit();//提交
            System.out.println(count);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            MybatisUtils.closeSqlSession();
        }
    }
}
