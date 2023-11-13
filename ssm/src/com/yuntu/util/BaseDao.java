package com.yuntu.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @BelongsProject: eat
 * @BelongsPackage: com.ytzl.util
 * @Author: shuo
 * @CreateTime: BaseDao
 * @Description:
 * @Version: 1.0
 */
public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    static {
        init();
    }

    private static void init() {
        Properties properties = new Properties();
        try {
            properties.load(BaseDao.class.getClassLoader().getResourceAsStream("database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        System.out.println(driver);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
    }

    public Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet query(String sql, Object... params) {
        conn = getConn();
        try {
            ps = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject((i + 1), params[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    public int update(String sql, Object... params) {
        int j = 0;
        conn = getConn();
        try {
            ps = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject((i + 1), params[i]);
                }
            }
            j = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return j;
    }
}
