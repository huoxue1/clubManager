package com.gjs.service;


import com.gjs.entity.H;
import com.gjs.entity.User;


public interface UserService {

    H Login(String account,String password);
    H Register(User user);

    H getUsers();

    H getUser(int id);


}
