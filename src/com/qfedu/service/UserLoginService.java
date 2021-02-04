package com.qfedu.service;

import com.qfedu.entity.User;

import java.util.List;

public interface UserLoginService {
    List<User> login(User user);
    int register(User user);
    User checkUser(String username);
}
