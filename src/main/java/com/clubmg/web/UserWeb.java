package com.clubmg.web;

import com.clubmg.controller.UserBaseController;
import com.clubmg.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserWeb {

    private static ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

    private static void getAll() {
        UserBaseController userBaseController = (UserBaseController) app.getBean("userController");
        List<User> allUser = userBaseController.getAll();
        for (User user : allUser) {
            System.out.println(user);
        }
    }

    private static void singUp() {
        User u = new User();
        u.setAccount(123);
        u.setPassword("12345");
        u.setName("A");
        UserBaseController userBaseController = (UserBaseController) app.getBean("userController");
//        userController.singUp(u);
    }

    public static void main(String[] args) {
        singUp();
        System.out.println("==============================");
    }


}
