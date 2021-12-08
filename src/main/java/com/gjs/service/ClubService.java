package com.gjs.service;

import com.gjs.entity.Club;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 社团(Club)表服务接口
 *
 * @author makejava
 * @since 2021-11-01 14:48:21
 */
public interface ClubService {


    List<Club> queryManagerClubs(Integer userId);



    List<Club> queryByState(Integer state);

    /**
     * 通过ID查询单条数据
     *
     * @param clubId 主键
     * @return 实例对象
     */
    Club queryById(Integer clubId);

    /**
     * 分页查询
     *
     * @param club        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Club> queryByPage(Club club, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param club 实例对象
     * @return 实例对象
     */
    Club insert(Club club);

    /**
     * 修改数据
     *
     * @param club 实例对象
     * @return 实例对象
     */
    Club update(Club club);

    /**
     * 通过主键删除数据
     *
     * @param clubId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer clubId);

}
