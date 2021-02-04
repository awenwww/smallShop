package com.qfedu.service.impl;

import com.qfedu.dao.UserLoginDao;
import com.qfedu.dao.impl.UserLoginDaoImpl;
import com.qfedu.entity.User;
import com.qfedu.service.UserLoginService;

import java.util.List;

public class UserLoginServiceImpl implements UserLoginService {
    @Override
    public List<User> login(User user) {
        UserLoginDao userLoginDao = new UserLoginDaoImpl();
        List<User> login = userLoginDao.login(user);
        return login;
    }
}
