package com.yuntu.service;

import com.yuntu.mapper.provider.ProviderMapper;
import com.yuntu.pojo.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.service
 * @Author: Shuo
 * @CreateTime: 2023-10-26  17:24
 * @Description:
 * @Version: 1.0
 */
@Service
public class ProviderServiceImpl implements ProviderService{
    @Autowired
    private ProviderMapper providerMapper;

    @Override
    public int getProviderCount(String queryProCode, String queryProName) {
        return providerMapper.getProviderCount(queryProCode,queryProName);
    }

    @Override
    public List<Provider> getProviderList(String queryProCode, String queryProName, int currentPageNo, int pageSize) throws SQLException {
        currentPageNo = (currentPageNo-1)*pageSize;
        List<Provider> providerList = providerMapper.getProviderList(queryProCode, queryProName, currentPageNo, pageSize);
        return providerList;
    }

    @Override
    public boolean add(Provider provider) {
        boolean flag = false;
        int add = providerMapper.add(provider);
        if (add!=0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Provider getProviderById(String id) throws SQLException {
        return providerMapper.getProviderById(id);
    }

    @Override
    public boolean updateProvider(Provider provider) {
        if (providerMapper.updateProvider(provider)>0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProviderById(Integer id) {
        if (providerMapper.deleteProviderById(id)>0) {
            return true;
        }
        return false;
    }
}
