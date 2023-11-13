package com.yuntu.service;

import com.yuntu.mapper.role.RoleDao;
import com.yuntu.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> selectAllRole() throws Exception {
        return roleDao.selectAllRole();
    }
}
