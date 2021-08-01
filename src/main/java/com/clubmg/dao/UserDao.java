package com.clubmg.dao;

import com.clubmg.pojo.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    List<User> getUser(long uid);

    List<User> getUser(Long account, String password);

    void singUp(User user);
}
