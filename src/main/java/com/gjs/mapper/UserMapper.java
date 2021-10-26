package com.gjs.mapper;

import com.gjs.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description user
 * @author gjs
 * @date 2021-09-29
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 新增
     * @author gjs
     * @date 2021/09/29
     **/

    int insert(User user);

    /**
     * 刪除
     * @author gjs
     * @date 2021/09/29
     **/
    int delete(int id);

    /**
     * 更新
     * @author gjs
     * @date 2021/09/29
     **/

    int update(User user);

    /**
     * 查询 根据主键 id 查询
     * @author gjs
     * @date 2021/09/29
     **/
    User load(int id);

    /**
     * 查询 分页查询
     * @author gjs
     * @date 2021/09/29
     **/
    List<User> pageList(int offset,int pagesize);

    /**
     * 查询 分页查询 count
     * @author gjs
     * @date 2021/09/29
     **/
    int pageListCount(int offset,int pagesize);



    User login(String account, String password);



    List<User> queryAll();

    User loadFromAccount(String account);

}