package com.yuntu.dao.test;

import com.yuntu.dao.bill.BillMapper;
import com.yuntu.pojo.Bill;
import com.yuntu.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @BelongsProject: MybatisAllTest
 * @BelongsPackage: com.yuntu.dao.test
 * @Author: Shuo
 * @CreateTime: 2023-09-04  12:52
 * @Description:
 * @Version: 1.0
 */
public class BillTest {
    @Test
    public void getBillList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Bill> list = sqlSession.getMapper(BillMapper.class).getBillList();
        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }
    @Test
    public void selectBillByNameTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        /*Map<String, Object> map = new HashMap<>();
        map.put("productName","碗");
        map.put("providerId",14);
        map.put("isPayment",2);*/
        List<Bill> list = sqlSession.getMapper(BillMapper.class).selectBillByName("",null,2);
        for (Bill bill : list) {
            System.out.println("供应商编码:"+bill.getBillCode()+"\t商品名称:"+bill.getProductName()+"\t供应商编码:"+bill.getProvider().getProCode()
                    +"\t供应商名称:"+bill.getProvider().getProName()+"\t供应商联系人:"+bill.getProvider().getProContact()
                    +"\t供应商联系电话:"+bill.getProvider().getProPhone()+"\t订单金额:"+bill.getTotalPrice()+"\t是否付款:"+(bill.getIsPayment()==1?"未付款":"已支付"));
        }
//        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }

}
