package com.yuntu.service;

import com.yuntu.mapper.role.RoleMapper;
import com.yuntu.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectAllRole() throws Exception {
        return roleMapper.selectAllRole();
    }
}
