package com.yuntu.mapper.bill;

import com.yuntu.pojo.Bill;
import org.apache.ibatis.annotations.Param;

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
public interface BillMapper {
    int getBillCount(@Param("billCode") String billCode,@Param("productName") String productName);

    List<Bill> getBillList(@Param("billCode")String billCode, @Param("productName")String productName,@Param("currentPageNo") int currentPageNo, @Param("pageSize") int pageSize) throws SQLException;

    int add(Bill bill);

    Bill getBillById(@Param("id")String id) throws SQLException;

    int updateBill(Bill bill);

    int deleteBillById(@Param("id") Integer id);
}
