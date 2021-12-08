package com.gjs.service;

import com.gjs.entity.Grade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 班级(Grade)表服务接口
 *
 * @author makejava
 * @since 2021-11-01 14:48:54
 */
public interface GradeService {


    Page<Grade> queryAll();
    /**
     * 通过ID查询单条数据
     *
     * @param gradeId 主键
     * @return 实例对象
     */
    Grade queryById(Integer gradeId);

    /**
     * 分页查询
     *
     * @param grade       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Grade> queryByPage(Grade grade, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param grade 实例对象
     * @return 实例对象
     */
    Grade insert(Grade grade);

    /**
     * 修改数据
     *
     * @param grade 实例对象
     * @return 实例对象
     */
    Grade update(Grade grade);

    /**
     * 通过主键删除数据
     *
     * @param gradeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer gradeId);

}
