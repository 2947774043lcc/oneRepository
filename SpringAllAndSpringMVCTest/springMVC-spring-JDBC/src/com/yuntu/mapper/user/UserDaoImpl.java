package com.yuntu.mapper.user;

import com.mysql.jdbc.StringUtils;
import com.yuntu.pojo.Role;
import com.yuntu.pojo.User;
import com.yuntu.util.BaseDao;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.dao.user
 * @Author: Shuo
 * @CreateTime: 2023-10-24  14:32
 * @Description:
 * @Version: 1.0
 */
@Repository
public class UserDaoImpl extends BaseDao  implements UserDao{
    @Override
    public User getLoginUser(String userCode) throws Exception {
        ResultSet rs=null;
        User user = null;
        if (null != userCode){
            String sql = "select * from smbms_user where userCode = ?";
            Object[] params = {userCode}; // 将参数放到数组中
            rs = query(sql,params);
            if (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setCode(rs.getString("userCode"));
            }
            close();
        }

        return user;
    }

    @Override
    public int getUserCode(String userName, int userRole) {
        ResultSet rs=null;
        StringBuffer sql = new StringBuffer();
        int count = 0;
        sql.append("select count(r.id) as count from smbms_user u,smbms_role r where u.userRole = r.id");
        List<Object> list = new ArrayList<>();
        if (!StringUtils.isNullOrEmpty(userName)){
            sql.append(" and u.userName like ?");
            list.add("%"+userName+"%");
        }
        if (userRole>0){
            sql.append(" and u.userRole = ?");
            list.add(userRole);
        }
        Object[] params = list.toArray();
        System.out.println("sql-->"+sql.toString());
        rs =query(sql.toString(),params);
        try {
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close();
        }
        return count;
    }

    @Override
    public List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize) throws SQLException {
        ResultSet rs=null;
        StringBuffer sql = new StringBuffer();
        List<User> users = new ArrayList<>();
        sql.append("select * from smbms_user u,smbms_role r where u.userRole = r.id ");
        List<Object> list = new ArrayList<>();
        if (!StringUtils.isNullOrEmpty(userName)) {
            sql.append(" and u.userName like ?");
            list.add("%"+userName+"%");
        }
        if (userRole>0){
            sql.append(" and u.userRole = ?");
            list.add(userRole);
        }
            sql.append(" order by u.creationDate DESC  limit ?,? ");
            list.add(currentPageNo);
            list.add(pageSize);
        Object[] params = list.toArray();
        System.out.println("sql-->"+sql.toString());
        rs =query(sql.toString(),params);
        while (rs.next()) {
            User user = new User();
            Role role = new Role();
            user.setId(rs.getInt("id"));
            user.setCode(rs.getString("userCode"));
            user.setUserName(rs.getString("userName"));
            user.setGender(rs.getInt("gender"));
            user.setBirthday(rs.getDate("birthday"));
            user.setPhone(rs.getString("phone"));
            user.setAddress(rs.getString("address"));
            role.setRoleName(rs.getString("roleName"));
            user.setRole(role);
            users.add(user);
        }
        close();
        return users;
    }

    @Override
    public int add(User user) {
        int count = 0;
        String sql = "insert into smbms_user (userCode,userName,userPassword," +
                "userRole,gender,birthday,phone,address,creationDate,createdBy,idPicPath,workPicPath) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {user.getCode(),user.getUserName(),user.getUserPassword(),
                user.getUserRole(),user.getGender(),user.getBirthday(),
                user.getPhone(),user.getAddress(),user.getCreationDate(),user.getCreatedBy(),
                user.getIdPicPath(),user.getWorkPicPath()};
         count = update(sql, params);
        return count;
    }

    @Override
    public User getUserById(String uid) throws SQLException {
        User user = null;
        String sql = "select * from smbms_user u,smbms_role r where u.userRole = r.id ";
        List<Object> list = new ArrayList<>();
        if (uid!=null && !uid.equals("")){
        sql+="and u.id = ?";
        list.add(uid);
        }
        ResultSet rs = query(sql, list.toArray());
        if (rs.next()) {
            Role role = new Role();
            user = new User();
            user.setId(rs.getInt("id"));
            user.setCode(rs.getString("userCode"));
            user.setUserName(rs.getString("userName"));
            user.setGender(rs.getInt("gender"));
            user.setBirthday(rs.getDate("birthday"));
            user.setPhone(rs.getString("phone"));
            user.setAddress(rs.getString("address"));
            role.setRoleName(rs.getString("roleName"));
            user.setRole(role);
        }
        close();
        return user;
    }

    @Override
    public int UpdateUser(User user) {
        int updateRow = 0;
        String sql = "update smbms_user set userName=?,gender=?,birthday=?,phone=?,address=?,userRole=?,modifyBy=?,modifyDate=? where id = ?";
        Object[] params = {user.getUserName(),user.getGender(),
                           user.getBirthday(),user.getPhone(),user.getAddress(),
                           user.getUserRole(),user.getModifyBy(),user.getModifyDate(),user.getId()};
        updateRow = update(sql, params);
        close();
        return updateRow;
    }

    @Override
    public int deleteUserById(Integer uid) {
        int deleteRow = 0;
        String sql = "delete from smbms_user where id = ?";
        Object[] params = {uid};
        deleteRow = update(sql, params);
        close();
        return deleteRow;
    }

    @Override
    public int updPwd(User user,String newPwd) {
        int updateRow = 0;
        String sql = "update smbms_user set userPassword=? where id = ?";
        Object[] params = {newPwd,user.getId()};
        updateRow = update(sql, params);
        close();
        return updateRow;
    }

    @Override
    public User getCode(String code) {
        String sql = "select * from smbms_user where userCode = ?";
        User user = null;
        Object[] params = {code};
        ResultSet rs = query(sql, params);
        try {
            if (rs.next()) {
                user = new  User();
                user.setCode(rs.getString("userCode"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close();
        }
        return user;
    }
}
