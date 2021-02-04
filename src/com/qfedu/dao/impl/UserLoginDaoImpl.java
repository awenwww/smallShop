package com.qfedu.dao.impl;

import com.qfedu.dao.UserLoginDao;
import com.qfedu.entity.User;
import com.qfedu.utils.BaseDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class UserLoginDaoImpl extends BaseDao implements UserLoginDao {
    @Override
    public List<User> login(User user) {
        String sql = "select * from user where username= ? and password= ?";
        Object [] part = {user.getUsername(),user.getPassword()};
        try {
            List<User> query = super.query(sql, part, User.class);
            if(query!=null||query.size()>0){
                return query;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
