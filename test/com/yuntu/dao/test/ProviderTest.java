package com.yuntu.dao.test;

import com.yuntu.dao.provider.ProviderMapper;
import com.yuntu.pojo.Provider;
import com.yuntu.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @BelongsProject: MybatisAllTest
 * @BelongsPackage: com.yuntu.dao.test
 * @Author: Shuo
 * @CreateTime: 2023-09-04  12:52
 * @Description:
 * @Version: 1.0
 */
public class ProviderTest {

    @org.junit.Test
    public void getProviderListTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Provider> list = sqlSession.getMapper(ProviderMapper.class).getProviderList();
        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }
    @Test
    public void selectProviderAndBillTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Provider> list = sqlSession.getMapper(ProviderMapper.class).selectProviderAndBill("",1);
        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }
}
