package com.qfedu.dao;

import com.qfedu.entity.User;

import java.util.List;

public interface UserLoginDao {
 List<User> login(User user);
 int register(User user);
 User checkUser(String username);
}
