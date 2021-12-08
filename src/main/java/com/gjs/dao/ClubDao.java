package com.gjs.dao;

import com.gjs.entity.Club;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import javax.annotation.ManagedBean;
import java.util.List;

/**
 * 社团(Club)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-01 14:48:20
 */
@Mapper
public interface ClubDao {



    List<Club> queryManagerClubs(Integer userId);

    /**
     * 通过ID查询单条数据
     *
     * @param clubId 主键
     * @return 实例对象
     */
    Club queryById(Integer clubId);

    /**
     * 查询指定行数据
     *
     * @param club     查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Club> queryAllByLimit(Club club, @Param("pageable") Pageable pageable);


    List<Club> queryByState(Integer State);


    /**
     * 统计总行数
     *
     * @param club 查询条件
     * @return 总行数
     */
    long count(Club club);

    /**
     * 新增数据
     *
     * @param club 实例对象
     * @return 影响行数
     */
    int insert(Club club);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Club> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Club> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Club> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Club> entities);

    /**
     * 修改数据
     *
     * @param club 实例对象
     * @return 影响行数
     */
    int update(Club club);

    /**
     * 通过主键删除数据
     *
     * @param clubId 主键
     * @return 影响行数
     */
    int deleteById(Integer clubId);

}

