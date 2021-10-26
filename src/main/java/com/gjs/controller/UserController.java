package com.gjs.controller;

import com.gjs.entity.H;
import com.gjs.service.UserService;
import com.gjs.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@Slf4j
@RestController
public class UserController {


    UserService userService;

    @RequestMapping("/login")
    public H Login(@RequestBody Map<String,String> data){
        log.info(String.valueOf(data));
        return userService.Login(data.get("account"),data.get("password"));
    }


    @RequestMapping("/get_users")
    public H getUsers(){
        return userService.getUsers();
    }


    @RequestMapping("/get_user")
    public H getUsers(@RequestBody Map<String,Object> data){
        return userService.getUser((Integer) data.get("id"));
    }


    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}
