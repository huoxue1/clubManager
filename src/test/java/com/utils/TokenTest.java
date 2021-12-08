package com.utils;

import com.gjs.clubmanager.ClubManagerApplication;
import com.gjs.entity.Club;
import com.gjs.entity.User;
import com.gjs.service.ClubService;
import com.gjs.utils.Token;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = ClubManagerApplication.class)
public class TokenTest {


    @Resource
    ClubService clubService;



    @Test
    public void test(){
        User user = new User();
        user.setUserId(6);
        user.setAccount("1234");
        System.out.println(Token.encode(user));
    }

    @Test
    public void test1(){
        List<Club> clubs = clubService.queryByState(0);
        for (Club c :clubs
                ) {
            System.out.println(c.getClubName());
        }
    }

}
