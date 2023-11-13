package com.yuntu.dao.test;

import com.yuntu.dao.address.AddressMapper;
import com.yuntu.pojo.Address;
import com.yuntu.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @BelongsProject: MybatisAllTest
 * @BelongsPackage: com.yuntu.dao.test
 * @Author: Shuo
 * @CreateTime: 2023-09-04  12:51
 * @Description:
 * @Version: 1.0
 */
public class AddressTest {
    @Test
    public void getAddressList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Address> list = sqlSession.getMapper(AddressMapper.class).getAddressList();
        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }
}
