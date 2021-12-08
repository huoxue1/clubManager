package com.gjs.service.impl;

import com.gjs.entity.Activity;
import com.gjs.dao.ActivityDao;
import com.gjs.service.ActivityService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 活动记录(Activity)表服务实现类
 *
 * @author makejava
 * @since 2021-11-01 15:32:57
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
    @Resource
    private ActivityDao activityDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Activity queryById(Integer id) {
        return this.activityDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param activity    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Activity> queryByPage(Activity activity, PageRequest pageRequest) {
        long total = this.activityDao.count(activity);
        return new PageImpl<>(this.activityDao.queryAllByLimit(activity, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param activity 实例对象
     * @return 实例对象
     */
    @Override
    public Activity insert(Activity activity) {
        this.activityDao.insert(activity);
        return activity;
    }

    /**
     * 修改数据
     *
     * @param activity 实例对象
     * @return 实例对象
     */
    @Override
    public Activity update(Activity activity) {
        this.activityDao.update(activity);
        return this.queryById(activity.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.activityDao.deleteById(id) > 0;
    }
}
