package com.yuntu.test;

import com.yuntu.dao.newUser.NewUserMapper;
import com.yuntu.pojo.User;
import com.yuntu.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class newUserMapperTest {
    @Test
    public void testGetUserList_chose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String userName = "张";
        Integer roleId = null;
        String userCode = "";
        Date creationDate = new Date();
        List<User> list = sqlSession.getMapper(NewUserMapper.class).getUserList_chose(userName, roleId, userCode, creationDate);
        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        NewUserMapper mapper = sqlSession.getMapper(NewUserMapper.class);
        List<User> users = mapper.selectAll();
        users.forEach(System.out::println);
    }

    @Test
    public void getUserListByLimitTest(){
        String name = "";
        Integer roleId = null;
        Integer pageSize = 5;
        Integer currentPage = 1;
        List<User> list = new ArrayList<User>();
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        list = sqlSession.getMapper(NewUserMapper.class).getUserListByLimit(name, roleId, (currentPage-1)*pageSize, pageSize);
        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();

    }
}
