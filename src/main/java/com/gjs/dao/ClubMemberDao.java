package com.gjs.dao;

import com.gjs.entity.ClubMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import javax.annotation.ManagedBean;
import java.util.List;

/**
 * 社团成员记录(ClubMember)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-01 15:24:02
 */
@Mapper
public interface ClubMemberDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClubMember queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param clubMember 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<ClubMember> queryAllByLimit(ClubMember clubMember, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param clubMember 查询条件
     * @return 总行数
     */
    long count(ClubMember clubMember);

    /**
     * 新增数据
     *
     * @param clubMember 实例对象
     * @return 影响行数
     */
    int insert(ClubMember clubMember);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ClubMember> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ClubMember> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ClubMember> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ClubMember> entities);

    /**
     * 修改数据
     *
     * @param clubMember 实例对象
     * @return 影响行数
     */
    int update(ClubMember clubMember);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

