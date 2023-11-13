package com.yuntu.service;

import com.yuntu.pojo.Bill;

import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.service
 * @Author: Shuo
 * @CreateTime: 2023-11-02  15:40
 * @Description:
 * @Version: 1.0
 */
public interface BillService {
    int getBillCount(String billCode,String productName);

    List<Bill> getBillList(String billCode, String productName, int currentPageNo, int pageSize) throws SQLException;

    boolean add(Bill bill);

    Bill getBillById(String id) throws SQLException;

    boolean updateBill(Bill bill);

    boolean deleteBillById(Integer id);
}
