package com.qfedu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    public int update(String sql,Object[] parameter) throws SQLException {
        //获取数据库的连接
        Connection connection = C3p0JdbcUtils.getConnection();
        //使用对应的sql获取对应的预处理搬运工
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //获取参数的个数（这个参数是sql语句的参数，即对应sql几个问号）
            int parameterCount = preparedStatement.getParameterMetaData().getParameterCount();
            //使用预处理的搬运工对象对sql语句进行赋值操作
            if (parameter != null && parameter.length == parameterCount) {
                for (int i = 1; i <= parameterCount; i++) {
                    preparedStatement.setObject(i, parameter[i - 1]);
                }
            }
            //执行sql语句
            int i = preparedStatement.executeUpdate();
            //关闭资源
           // JdbcUtil.close(connection, preparedStatement);
            return i;
    }
    public <T> List<T> query(String sql,Object[] parameters,Class<T> cls) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if(sql == null || cls ==null) {
            throw new NullPointerException();
        }
        //获取数据库的连接
        Connection connection = C3p0JdbcUtils.getConnection();
        //使用对应的sql获取对应的预处理搬运工
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //获取参数的个数，sql语句的？个数
        int parameterCount = preparedStatement.getParameterMetaData().getParameterCount();
        //使用预处理搬运工对象对sql语句进行赋值操作
        if(parameters != null && parameters.length == parameterCount) {
            for (int i = 1; i <= parameters.length ; i++) {
                preparedStatement.setObject(i,parameters[i-1]);
            }
        }
        //执行sql语句
        ResultSet resultSet = preparedStatement.executeQuery();
        //new一个list集合来存储对象
        List<T> list = new ArrayList<>();
        //获取结果集元数据
        ResultSetMetaData metaData = resultSet.getMetaData();
        //获取参数元数据
        int columnCount = metaData.getColumnCount();
        //遍历
        while(resultSet.next()) {
            //用反射来创建对象，来接数据查询出来的数据 eg：Dept dept = new Dept()
            T t = cls.getConstructor(null).newInstance(null);
            for (int i = 1; i <= columnCount ; i++) {
                //获取字段的名字
                String columnName = metaData.getColumnName(i);
                //获取字段的数据
                Object value = resultSet.getObject(columnName);
                //使用BeanUtils对获取的字段名字及字段数据给类对象赋值
                BeanUtils.setProperty(t,columnName,value);
            }
            //把对象添加到list集合中
        list.add(t);
        }
        //关闭资源
       // C3p0JdbcUtils.close(connection,preparedStatement,resultSet);
        //返回list集合
        return list != null?list:null;
    }
}
