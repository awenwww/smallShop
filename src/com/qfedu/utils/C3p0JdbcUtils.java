package com.qfedu.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3p0JdbcUtils {
    private static ComboPooledDataSource pool = new ComboPooledDataSource();
    public static Connection getConnection() {
        Connection connection=null;
        try {
           connection = pool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    /**
     *
     * 关闭数据库连接对象
     */

    public static void close(Connection connection) throws SQLException {
        close(connection,null,null);
    }
    public static void close(Connection connection, Statement statement) throws SQLException {
        close(connection,statement,null);
    }
    public static void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if(connection != null){

                connection.close();

        }
        if(statement != null){

                connection.close();

        }
        if(resultSet != null){

                connection.close();

        }

    }
}
