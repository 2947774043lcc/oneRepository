package com.yuntu.mapper.provider;

import com.yuntu.pojo.Provider;
import org.apache.ibatis.annotations.Param;

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
public interface ProviderMapper {

    int getProviderCount(@Param("queryProCode") String queryProCode,@Param("queryProName") String queryProName);

    List<Provider> getProviderList(@Param("queryProCode")String queryProCode, @Param("queryProName")String queryProName,@Param("currentPageNo") int currentPageNo,@Param("pageSize") int pageSize) throws SQLException;

    int add(Provider provider);

    Provider getProviderById(@Param("id") String id) throws SQLException;

    int updateProvider(Provider provider);

    int deleteProviderById(@Param("id") Integer id);
}
