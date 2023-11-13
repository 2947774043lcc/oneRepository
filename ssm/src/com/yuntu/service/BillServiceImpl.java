package com.yuntu.service;

import com.yuntu.mapper.bill.BillMapper;
import com.yuntu.pojo.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillMapper billMapper;
    @Override
    public int getBillCount(String billCode, String productName) {
        return billMapper.getBillCount(billCode,productName);
    }

    @Override
    public List<Bill> getBillList(String billCode, String productName, int currentPageNo, int pageSize) throws SQLException {
        currentPageNo = (currentPageNo-1)*pageSize;
        List<Bill> billList = billMapper.getBillList(billCode, productName, currentPageNo, pageSize);
        return billList;
    }

    @Override
    public boolean add(Bill bill) {
        boolean flag = false;
        int add = billMapper.add(bill);
        if (add!=0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Bill getBillById(String id) throws SQLException {
        return billMapper.getBillById(id);
    }

    @Override
    public boolean updateBill(Bill bill) {
        if (billMapper.updateBill(bill)>0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBillById(Integer id) {
        if (billMapper.deleteBillById(id)>0) {
            return true;
        }
        return false;
    }
}
