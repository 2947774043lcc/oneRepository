package com.yuntu.dao.role;

import com.yuntu.pojo.Address;
import com.yuntu.pojo.Role;

import java.util.List;

/**
 * @BelongsProject: MybatisAllTest
 * @BelongsPackage: com.yuntu.dao.role
 * @Author: Shuo
 * @CreateTime: 2023-08-30  10:49
 * @Description:
 * @Version: 1.0
 */
public interface RoleMapper {
    List<Role> getRoleList();
    int addRole(Role role);
    int updateRole(Role role);
    int deleteRole(Long id);
}
