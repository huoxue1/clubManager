package com.gjs.dao;

import com.gjs.entity.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 班级(Grade)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-01 14:48:54
 */
@Mapper
public interface GradeDao {





    List<Grade> queryAll();
    /**
     * 通过ID查询单条数据
     *
     * @param gradeId 主键
     * @return 实例对象
     */
    Grade queryById(Integer gradeId);

    /**
     * 查询指定行数据
     *
     * @param grade    查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Grade> queryAllByLimit(Grade grade, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param grade 查询条件
     * @return 总行数
     */
    long count(Grade grade);

    /**
     * 新增数据
     *
     * @param grade 实例对象
     * @return 影响行数
     */
    int insert(Grade grade);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Grade> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Grade> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Grade> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Grade> entities);

    /**
     * 修改数据
     *
     * @param grade 实例对象
     * @return 影响行数
     */
    int update(Grade grade);

    /**
     * 通过主键删除数据
     *
     * @param gradeId 主键
     * @return 影响行数
     */
    int deleteById(Integer gradeId);

}

