package com.yuntu.dao.provider;

import com.yuntu.pojo.Address;
import com.yuntu.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: MybatisAllTest
 * @BelongsPackage: com.yuntu.dao.provider
 * @Author: Shuo
 * @CreateTime: 2023-08-30  10:48
 * @Description:
 * @Version: 1.0
 */
public interface ProviderMapper {
    List<Provider> getProviderList();
    int addProvider(Provider provider);
    int updateProvider(Provider provider);
    int deleteProvider(Long id);

//    List<Provider> selectProviderAndBill(@Param("providerId") Integer providerId);
    List<Provider> selectProviderAndBill(@Param("proName") String proName,@Param("providerId") Integer providerId);
}
