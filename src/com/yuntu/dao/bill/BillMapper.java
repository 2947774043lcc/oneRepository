package com.yuntu.dao.bill;

import com.yuntu.pojo.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: MybatisAllTest
 * @BelongsPackage: com.yuntu.dao.bill
 * @Author: Shuo
 * @CreateTime: 2023-08-30  10:47
 * @Description:
 * @Version: 1.0
 */
public interface BillMapper {
    List<Bill> getBillList();
    int addBill(Bill bill);
    int updateBill(Bill bill);
    int deleteBill(Long id);
    List<Bill> selectBillByName(@Param("productName") String productName,@Param("providerId")
    Integer providerId, @Param("isPayment") Integer isPayment);
}
