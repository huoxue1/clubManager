package com.gjs.dao.impl;

import com.gjs.dao.UserDao;
import com.gjs.entity.User;
import com.gjs.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    private UserMapper userMapper;

    @Override
    public User load(int id) {
        return userMapper.load(id);
    }

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    @Override
    public User login(String account, String password) {
        return userMapper.login(account,password);
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
