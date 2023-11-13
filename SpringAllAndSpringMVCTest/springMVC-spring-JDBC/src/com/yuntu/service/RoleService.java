package com.yuntu.service;

import com.yuntu.pojo.Role;

import java.sql.Connection;
import java.util.List;

public interface RoleService {

    List<Role> selectAllRole() throws Exception;
}
