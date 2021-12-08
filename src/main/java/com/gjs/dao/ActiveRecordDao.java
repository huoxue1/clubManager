package com.gjs.dao;

import com.gjs.entity.ActiveRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 活动包名记录(ActiveRecord)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-01 15:40:23
 */
@Mapper
public interface ActiveRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ActiveRecord queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param activeRecord 查询条件
     * @param pageable     分页对象
     * @return 对象列表
     */
    List<ActiveRecord> queryAllByLimit(ActiveRecord activeRecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param activeRecord 查询条件
     * @return 总行数
     */
    long count(ActiveRecord activeRecord);

    /**
     * 新增数据
     *
     * @param activeRecord 实例对象
     * @return 影响行数
     */
    int insert(ActiveRecord activeRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ActiveRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ActiveRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ActiveRecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ActiveRecord> entities);

    /**
     * 修改数据
     *
     * @param activeRecord 实例对象
     * @return 影响行数
     */
    int update(ActiveRecord activeRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

