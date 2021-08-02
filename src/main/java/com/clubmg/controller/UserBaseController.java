package com.clubmg.controller;

import com.alibaba.fastjson.JSONObject;
import com.clubmg.pojo.User;
import com.clubmg.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;


@Controller("userController")
public class UserBaseController {
    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> login(@RequestBody Map<String,String> params, HttpSession session) {
        long account = Long.parseLong(params.get("account"));
        String password = params.get("password");
        List<User> users = userService.getUser(account, password);
        HashMap<String, String> map = new HashMap<>();

        if (users.size() == 1) {
            System.out.println("-------------------------------");
            System.out.println(users.get(0));
            System.out.println("-------------------------------");
            session.setAttribute("user", users.get(0));
            session.setAttribute("uid",users.get(0).getUid());
            map.put("code", 1 + "");
            map.put("msg", "成功");
        } else {
            map.put("code", -1 + "");
            map.put("msg", "账号或密码错误");
        }

        return map;
    }


    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @ResponseBody
    public int logout(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            session.invalidate();
            return 1;
        }
        return -1;
    }

    @RequestMapping(value = "/get_current_uid",method = RequestMethod.POST)
    @ResponseBody
    public long getCurrentUid(HttpSession session){
        long uid= (long) session.getAttribute("uid");
        return uid;
    }

    @RequestMapping(value = "get_user",method = RequestMethod.POST)
    @ResponseBody
    public User getUser(Long uid) {
        User user = null;
        List<User> users = userService.getUser(uid);
        if (users.size() == 1) {
            user = users.get(0);
        }
        return user;
    }


    @RequestMapping(value = "get_users",method = RequestMethod.POST)
    @ResponseBody
    public List<User> getAll() {
        return userService.getAll();
    }


    @RequestMapping(value = "/get_user_id",method = RequestMethod.POST)
    @ResponseBody
    public long getCurrentId(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) return user.getUid();
        return -1;
    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public int singUp( User user) {
        System.out.println("-----------------------------");
        System.out.println(user);
        System.out.println("-----------------------------");

        user.setPermit(0);
        userService.singUp(user);
        return 1;
    }



    @ResponseBody
    @ExceptionHandler(Exception.class)
    public int exceptionHandler() {
        System.out.println("\n\n");
        System.out.println("-----------------------------");
        System.out.println("In Base ExceptionHandler");
        return -1;
    }


}
