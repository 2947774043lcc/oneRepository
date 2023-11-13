package com.yuntu.mapper.role;

import com.yuntu.pojo.Role;

import java.util.List;

public interface RoleMapper {
    /**
     * 查询所以的职位
     * @return
     */
    List<Role> selectAllRole() throws Exception;
}
