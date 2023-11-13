package com.yuntu.mapper.bill;

import com.yuntu.pojo.Bill;

import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.dao.bill
 * @Author: Shuo
 * @CreateTime: 2023-11-02  15:22
 * @Description:
 * @Version: 1.0
 */
public interface BillDao {
    int getBillCount(String billCode,String productName);

    List<Bill> getBillList(String billCode, String productName, int currentPageNo, int pageSize) throws SQLException;

    int add(Bill bill);

    Bill getBillById(String id) throws SQLException;

    int updateBill(Bill bill);

    int deleteBillById(Integer id);
}
