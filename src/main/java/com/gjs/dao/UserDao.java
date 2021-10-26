package com.gjs.dao;

import com.gjs.entity.H;
import com.gjs.entity.User;

import java.util.List;

public interface UserDao {

    User load(int id);
    List<User> queryAll();
    User login(String account,String password);

}
