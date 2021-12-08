package com.gjs.service.impl;

import com.gjs.entity.User;
import com.gjs.dao.UserDao;
import com.gjs.exception.exceptionImpl.CustomException;
import com.gjs.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 用户信息(User)表服务实现类
 *
 * @author makejava
 * @since 2021-11-01 14:49:35
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User Login(String account,String password) {
        User user = userDao.queryByAccount(account);
        if (user == null) {
            return null;
        }
        if (!(user.getPassword().equals(password))){
            return null;
        }
        return user;
    }

    @Override
    public Page<User> queryAll() {
        long total = this.userDao.count(null);
        return new PageImpl<>(this.userDao.queryAll(), PageRequest.of(1,10), total);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer userId) {
        return this.userDao.queryById(userId);
    }

    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userDao.count(user);
        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        User user1 = userDao.queryByAccount(user.getAccount());
        if (null != user1){
            throw new CustomException(1400,"账号已存在");
        }
        user.setUserAvatar("default.png");
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.userDao.deleteById(userId) > 0;
    }
}
