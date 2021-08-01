package com.clubmg.service;


import com.clubmg.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface UserService {

    @Transactional(readOnly = true)
    List<User> getAll();

    List<User> getUser(long uid);

    List<User> getUser(Long account, String password);

    void singUp(User user);

}
