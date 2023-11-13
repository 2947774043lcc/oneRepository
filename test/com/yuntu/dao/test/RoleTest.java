package com.yuntu.dao.test;

import com.yuntu.dao.role.RoleMapper;
import com.yuntu.pojo.Role;
import com.yuntu.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @BelongsProject: MybatisAllTest
 * @BelongsPackage: com.yuntu.dao.test
 * @Author: Shuo
 * @CreateTime: 2023-09-04  12:52
 * @Description:
 * @Version: 1.0
 */
public class RoleTest {

    @org.junit.Test
    public void getRoleList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Role> list = sqlSession.getMapper(RoleMapper.class).getRoleList();
        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }
}
