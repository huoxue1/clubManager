package com.gjs.service;

import com.gjs.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 用户信息(User)表服务接口
 *
 * @author makejava
 * @since 2021-11-01 14:49:34
 */
public interface UserService {


    User Login(String account,String password);


    /**
     *
     * 查询所有内容
     *
     */
    Page<User> queryAll();


    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Integer userId);

    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<User> queryByPage(User user, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

}
