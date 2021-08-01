package com.clubmg.service.impl;

import com.clubmg.dao.UserDao;
import com.clubmg.pojo.User;
import com.clubmg.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public List<User> getUser(long uid) {
        return userDao.getUser(uid);
    }

    @Override
    public List<User> getUser(Long account, String password) {
        return userDao.getUser(account, password);
    }

    @Override
    public void singUp(User user) {
        userDao.singUp(user);
    }
}
