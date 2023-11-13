package com.yuntu.mapper.role;

import com.yuntu.pojo.Role;
import com.yuntu.util.BaseDao;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


@Repository
public class RoleDaoImpl extends BaseDao implements RoleDao{
    @Override
    public List<Role> selectAllRole() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Role> roles = new ArrayList<>();
            String sql = "select * from smbms_role";
            Object[] prams = {};
            rs= query(sql,prams);
            Role role = null;
            while (rs.next()) {
                role = new Role(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getDate(7)
                );
                roles.add(role);
            }
            close();
        return roles;
    }
}
