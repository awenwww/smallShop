package com.qfedu.service.impl;

import com.qfedu.dao.UserLoginDao;
import com.qfedu.dao.impl.UserLoginDaoImpl;
import com.qfedu.entity.User;
import com.qfedu.service.UserLoginService;

import java.util.List;

public class UserLoginServiceImpl implements UserLoginService {
    UserLoginDao userLoginDao = new UserLoginDaoImpl();
    @Override
    public List<User> login(User user) {
        List<User> login = userLoginDao.login(user);
        return login;
    }
    @Override
    public int register(User user) {
        int register = userLoginDao.register(user);
        return register;
    }

    @Override
    public User checkUser(String username) {
        User user = userLoginDao.checkUser(username);
        return user;
    }
}
