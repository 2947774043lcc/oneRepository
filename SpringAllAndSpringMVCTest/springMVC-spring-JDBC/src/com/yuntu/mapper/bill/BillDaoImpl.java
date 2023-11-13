package com.yuntu.mapper.bill;

import com.mysql.jdbc.StringUtils;
import com.yuntu.pojo.Bill;
import com.yuntu.util.BaseDao;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.dao.bill
 * @Author: Shuo
 * @CreateTime: 2023-11-02  15:24
 * @Description:
 * @Version: 1.0
 */
@Repository
public class BillDaoImpl extends BaseDao implements BillDao {
    @Override
    public int getBillCount(String billCode, String productName) {
        ResultSet rs=null;
        StringBuffer sql = new StringBuffer();
        int count = 0;
        sql.append("select count(id) as count from smbms_bill  where 1=1");
        List<Object> list = new ArrayList<>();
        if (!StringUtils.isNullOrEmpty(billCode)){
            sql.append(" and billCode like ?");
            list.add("%"+billCode+"%");
        }
        if (!StringUtils.isNullOrEmpty(productName)){
            sql.append(" and productName like ?");
            list.add("%"+productName+"%");
        }
        Object[] params = list.toArray();
        System.out.println("sql-->"+sql.toString());
        rs =query(sql.toString(),params);
        try {
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close();
        }
        return count;
    }

    @Override
    public List<Bill> getBillList(String billCode, String productName, int currentPageNo, int pageSize) throws SQLException {
        ResultSet rs=null;
        StringBuffer sql = new StringBuffer();
        List<Bill> billList = new ArrayList<>();
        sql.append("select * from smbms_bill  where 1=1 ");
        List<Object> list = new ArrayList<>();
        if (!StringUtils.isNullOrEmpty(billCode)){
            sql.append(" and billCode like ?");
            list.add("%"+billCode+"%");
        }
        if (!StringUtils.isNullOrEmpty(productName)){
            sql.append(" and productName like ?");
            list.add("%"+productName+"%");
        }
        sql.append(" order by creationDate DESC  limit ?,? ");
        list.add(currentPageNo);
        list.add(pageSize);
        Object[] params = list.toArray();
        System.out.println("sql-->"+sql.toString());
        rs =query(sql.toString(),params);
        while (rs.next()) {
            Bill bill = new Bill();
            bill.setId(rs.getInt("id"));
            bill.setBillCode(rs.getString("billCode"));
            bill.setProductName(rs.getString("productName"));
            bill.setProductDesc(rs.getString("productDesc"));
            bill.setProductUnit(rs.getString("productUnit"));
            bill.setProductCount(rs.getDouble("productCount"));
            bill.setTotalPrice(rs.getDouble("totalPrice"));
            bill.setProviderId(rs.getInt("providerId"));
            bill.setCreatedBy(rs.getInt("createdBy"));
            bill.setCreationDate(rs.getDate("creationDate"));
            bill.setModifyDate(rs.getDate("modifyDate"));
            bill.setModifyBy(rs.getInt("modifyBy"));
            billList.add(bill);
        }
        close();
        return billList;
    }

    @Override
    public int add(Bill bill) {
        int count = 0;
        String sql = "insert into smbms_bill (billCode,productName,productDesc," +
                "productUnit,productCount,totalPrice,providerId,createdBy,creationDate) " +
                "values(?,?,?,?,?,?,?,?,?)";
        Object[] params = {bill.getBillCode(),bill.getProductName(),bill.getProductDesc()
                ,bill.getProductUnit(),bill.getProductCount(),
                bill.getTotalPrice(),bill.getProviderId(),bill.getCreatedBy(),
                bill.getCreationDate()};
        count = update(sql, params);
        return count;
    }

    @Override
    public Bill getBillById(String id) throws SQLException {
        Bill bill = null;
        String sql = "select * from smbms_bill where 1 = 1 ";
        List<Object> list = new ArrayList<>();
        if (id!=null && !id.equals("")){
            sql+="and id = ?";
            list.add(id);
        }
        ResultSet rs = query(sql, list.toArray());
        if (rs.next()) {
            bill = new Bill();
            bill.setId(rs.getInt("id"));
            bill.setBillCode(rs.getString("billCode"));
            bill.setProductName(rs.getString("productName"));
            bill.setProductDesc(rs.getString("productDesc"));
            bill.setProductUnit(rs.getString("productUnit"));
            bill.setProductCount(rs.getDouble("productCount"));
            bill.setTotalPrice(rs.getDouble("totalPrice"));
            bill.setProviderId(rs.getInt("providerId"));
            bill.setCreatedBy(rs.getInt("createdBy"));
            bill.setCreationDate(rs.getDate("creationDate"));
            bill.setModifyDate(rs.getDate("modifyDate"));
            bill.setModifyBy(rs.getInt("modifyBy"));
        }
        close();
        return bill;
    }

    @Override
    public int updateBill(Bill bill) {
        int updateRow = 0;
        String sql = "update smbms_bill set productName=?,productDesc=?," +
                "productUnit=?,productCount=?,totalPrice=?,providerId=?,modifyBy=?,modifyDate=? where id = ?";
        Object[] params = {bill.getProductName(),
                bill.getProductDesc(),bill.getProductUnit(),
                bill.getProductCount(),bill.getTotalPrice(),
                bill.getProviderId(),bill.getModifyBy(),bill.getModifyDate(),bill.getId()};
        updateRow = update(sql, params);
        close();
        return updateRow;
    }

    @Override
    public int deleteBillById(Integer id) {
        int deleteRow = 0;
        String sql = "delete from smbms_bill where id = ?";
        Object[] params = {id};
        deleteRow = update(sql, params);
        close();
        return deleteRow;
    }
}
