package com.yuntu.mapper.provider;

import com.mysql.jdbc.StringUtils;
import com.yuntu.pojo.Provider;
import com.yuntu.util.BaseDao;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.dao.provider
 * @Author: Shuo
 * @CreateTime: 2023-10-26  16:53
 * @Description:
 * @Version: 1.0
 */
@Repository
public class ProviderDaoImpl extends BaseDao implements ProviderDao{
    @Override
    public int getProviderCount(String queryProCode, String queryProName) {
        ResultSet rs=null;
        StringBuffer sql = new StringBuffer();
        int count = 0;
        sql.append("select count(id) as count from smbms_provider  where 1=1");
        List<Object> list = new ArrayList<>();
        if (!StringUtils.isNullOrEmpty(queryProCode)){
            sql.append(" and proCode like ?");
            list.add("%"+queryProCode+"%");
        }
        if (!StringUtils.isNullOrEmpty(queryProName)){
            sql.append(" and proName like ?");
            list.add("%"+queryProName+"%");
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
    public List<Provider> getProviderList(String queryProCode, String queryProName, int currentPageNo, int pageSize) throws SQLException {
        ResultSet rs=null;
        StringBuffer sql = new StringBuffer();
        List<Provider> providerList = new ArrayList<>();
        sql.append("select * from smbms_provider  where 1=1 ");
        List<Object> list = new ArrayList<>();
        if (!StringUtils.isNullOrEmpty(queryProCode)){
            sql.append(" and proCode like ?");
            list.add("%"+queryProCode+"%");
        }
        if (!StringUtils.isNullOrEmpty(queryProName)){
            sql.append(" and proName like ?");
            list.add("%"+queryProName+"%");
        }
        sql.append(" order by creationDate DESC  limit ?,? ");
        list.add(currentPageNo);
        list.add(pageSize);
        Object[] params = list.toArray();
        System.out.println("sql-->"+sql.toString());
        rs =query(sql.toString(),params);
        while (rs.next()) {
            Provider provider = new Provider();
            provider.setId(rs.getInt(1));
            provider.setProCode(rs.getString(2));
            provider.setProName(rs.getString(3));
            provider.setProDesc(rs.getString(4));
            provider.setProContact(rs.getString(5));
            provider.setProPhone(rs.getString(6));
            provider.setProAddress(rs.getString(7));
            provider.setProFax(rs.getString(8));
            provider.setCreatedBy(rs.getInt(9));
            provider.setCreationDate(rs.getDate(10));
            provider.setModifyDate(rs.getDate(11));
            provider.setModifyBy(rs.getInt(12));
            providerList.add(provider);
        }
        close();
        return providerList;
    }

    @Override
    public int add(Provider provider) {
        int count = 0;
        String sql = "insert into smbms_provider (proCode,proName,proDesc," +
                "proContact,proPhone,proAddress,proFax,createdBy,creationDate,idPicPath) " +
                "values(?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {provider.getProCode(),provider.getProName(),
        provider.getProDesc(),provider.getProContact(),provider.getProPhone(),
        provider.getProAddress(),provider.getProFax(),provider.getCreatedBy(),
        provider.getCreationDate(),provider.getIdPicPath()};
        count = update(sql, params);
        return count;
    }

    @Override
    public Provider getProviderById(String id) throws SQLException {
        Provider provider = null;
        String sql = "select * from smbms_provider where 1 = 1 ";
        List<Object> list = new ArrayList<>();
        if (id!=null && !id.equals("")){
            sql+="and id = ?";
            list.add(id);
        }
        ResultSet rs = query(sql, list.toArray());
        if (rs.next()) {
            provider = new Provider();
            provider.setId(rs.getInt(1));
            provider.setProCode(rs.getString(2));
            provider.setProName(rs.getString(3));
            provider.setProDesc(rs.getString(4));
            provider.setProContact(rs.getString(5));
            provider.setProPhone(rs.getString(6));
            provider.setProAddress(rs.getString(7));
            provider.setProFax(rs.getString(8));
            provider.setCreatedBy(rs.getInt(9));
            provider.setCreationDate(rs.getDate(10));
            provider.setModifyDate(rs.getDate(11));
            provider.setModifyBy(rs.getInt(12));
        }
        close();
        return provider;
    }

    @Override
    public int updateProvider(Provider provider) {
        int updateRow = 0;
        String sql = "update smbms_provider set proCode=?,proName=?,proDesc=?,proContact=?,proPhone=?,proAddress=?,proFax=?,modifyBy=?,modifyDate=? where id = ?";
        Object[] params = {provider.getProCode(),provider.getProName(),
                provider.getProDesc(),provider.getProContact(),provider.getProPhone(),
                provider.getProAddress(),provider.getProFax(),provider.getModifyBy(),provider.getModifyDate(),provider.getId()};
        updateRow = update(sql, params);
        close();
        return updateRow;
    }

    @Override
    public int deleteProviderById(Integer id) {
        int deleteRow = 0;
        String sql = "delete from smbms_provider where id = ?";
        Object[] params = {id};
        deleteRow = update(sql, params);
        close();
        return deleteRow;
    }

}
