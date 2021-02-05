package com.qfedu.dao;


import com.qfedu.entity.Admin;
import com.qfedu.utils.C3p0JdbcUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    Admin admin1 = null;
    public  Admin login(String adminName, String adminPassword) throws SQLException, InvocationTargetException, IllegalAccessException {
        String sql = "select * from admin where adminName=? and adminPassword=?";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        connection = C3p0JdbcUtils.getConnection();
        ps = connection.prepareStatement(sql);
        ps.setString(1, adminName);
        ps.setString(2, adminPassword);
        rs = ps.executeQuery();
        if (rs.next()) {
            String columnName = ps.getMetaData().getColumnName(1);//获取数据库的字段
            String value = rs.getString(columnName);//获取字段数据
            //user1 = new User("user","password");
            admin1 = new Admin(columnName,value);
        }
        return admin1;
    }
}
