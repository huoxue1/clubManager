package com.gjs.service;

import com.gjs.entity.ActiveRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 活动包名记录(ActiveRecord)表服务接口
 *
 * @author makejava
 * @since 2021-11-01 15:40:23
 */
public interface ActiveRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ActiveRecord queryById(Integer id);

    /**
     * 分页查询
     *
     * @param activeRecord 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    Page<ActiveRecord> queryByPage(ActiveRecord activeRecord, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param activeRecord 实例对象
     * @return 实例对象
     */
    ActiveRecord insert(ActiveRecord activeRecord);

    /**
     * 修改数据
     *
     * @param activeRecord 实例对象
     * @return 实例对象
     */
    ActiveRecord update(ActiveRecord activeRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
