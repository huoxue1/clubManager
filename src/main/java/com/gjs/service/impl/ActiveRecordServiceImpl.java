package com.gjs.service.impl;

import com.gjs.entity.ActiveRecord;
import com.gjs.dao.ActiveRecordDao;
import com.gjs.service.ActiveRecordService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 活动包名记录(ActiveRecord)表服务实现类
 *
 * @author makejava
 * @since 2021-11-01 15:40:23
 */
@Service("activeRecordService")
public class ActiveRecordServiceImpl implements ActiveRecordService {
    @Resource
    private ActiveRecordDao activeRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ActiveRecord queryById(Integer id) {
        return this.activeRecordDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param activeRecord 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    @Override
    public Page<ActiveRecord> queryByPage(ActiveRecord activeRecord, PageRequest pageRequest) {
        long total = this.activeRecordDao.count(activeRecord);
        return new PageImpl<>(this.activeRecordDao.queryAllByLimit(activeRecord, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param activeRecord 实例对象
     * @return 实例对象
     */
    @Override
    public ActiveRecord insert(ActiveRecord activeRecord) {
        this.activeRecordDao.insert(activeRecord);
        return activeRecord;
    }

    /**
     * 修改数据
     *
     * @param activeRecord 实例对象
     * @return 实例对象
     */
    @Override
    public ActiveRecord update(ActiveRecord activeRecord) {
        this.activeRecordDao.update(activeRecord);
        return this.queryById(activeRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.activeRecordDao.deleteById(id) > 0;
    }
}
