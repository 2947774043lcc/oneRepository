package com.yuntu.mapper.provider;

import com.yuntu.pojo.Provider;

import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.dao.provider
 * @Author: Shuo
 * @CreateTime: 2023-10-26  16:37
 * @Description:
 * @Version: 1.0
 */
public interface ProviderDao {

    int getProviderCount(String queryProCode,String queryProName);

    List<Provider> getProviderList(String queryProCode, String queryProName, int currentPageNo, int pageSize) throws SQLException;

    int add(Provider provider);

    Provider getProviderById(String id) throws SQLException;

    int updateProvider(Provider provider);

    int deleteProviderById(Integer id);
}
