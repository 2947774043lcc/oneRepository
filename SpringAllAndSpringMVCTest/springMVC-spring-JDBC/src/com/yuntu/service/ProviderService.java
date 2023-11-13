package com.yuntu.service;

import com.yuntu.pojo.Provider;

import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.service
 * @Author: Shuo
 * @CreateTime: 2023-10-26  17:23
 * @Description:
 * @Version: 1.0
 */
public interface ProviderService {
    int getProviderCount(String queryProCode,String queryProName);

    List<Provider> getProviderList(String queryProCode, String queryProName, int currentPageNo, int pageSize) throws SQLException;

    boolean add(Provider provider);

    Provider getProviderById(String id) throws SQLException;

    boolean updateProvider(Provider provider);

    boolean deleteProviderById(Integer id);
}
