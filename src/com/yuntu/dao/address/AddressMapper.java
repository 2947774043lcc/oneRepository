package com.yuntu.dao.address;

import com.yuntu.pojo.Address;

import java.util.List;

/**
 * @BelongsProject: MybatisAllTest
 * @BelongsPackage: com.yuntu.dao.address
 * @Author: Shuo
 * @CreateTime: 2023-08-30  10:46
 * @Description:
 * @Version: 1.0
 */
public interface AddressMapper {
    List<Address> getAddressList();
    int addAddress(Address address);
    int updateAddress(Address address);
    int deleteAddress(Long id);

    /**
     * 批量新增
     * @param list
     * @return
     */
    int batchInsertAddress(List<Address> list);
}
