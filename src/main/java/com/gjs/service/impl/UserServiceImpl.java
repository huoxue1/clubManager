package com.gjs.service.impl;

import com.gjs.mapper.UserMapper;
import com.gjs.entity.H;
import com.gjs.entity.User;
import com.gjs.exception.CommonEnum;
import com.gjs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;



    @Override
    public H Login(String account,String password) {
        User login = userMapper.login(account, password);
        if (login == null){
            return H.error(CommonEnum.SIGNATURE_NOT_MATCH);
        }else {
            return H.success(login);
        }
    }

    @Override
    public H Register(User user) {
        if (userMapper.loadFromAccount(user.getAccount()) != null) {
            return H.error("已存在相同账号");
        }
        int i = userMapper.insert(user);
        if (i<0){
            return H.error("插入数据库发生未知错误");
        }
        return H.success("注册成功");
    }



    @Override
    public H getUsers() {
        List<User> users = userMapper.queryAll();
        return H.success(users);
    }

    @Override
    public H getUser(int id) {
        User login = userMapper.load(id);
        if (login == null){
            return H.error(CommonEnum.SIGNATURE_NOT_MATCH);
        }else {
            return H.success(login);
        }
    }


    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
