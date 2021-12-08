package com.gjs.service.impl;

import com.gjs.entity.Grade;
import com.gjs.dao.GradeDao;
import com.gjs.service.GradeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 班级(Grade)表服务实现类
 *
 * @author makejava
 * @since 2021-11-01 14:48:54
 */
@Service("gradeService")
public class GradeServiceImpl implements GradeService {
    @Resource
    private GradeDao gradeDao;

    @Override
    public Page<Grade> queryAll() {
        long total = this.gradeDao.count(null);
        return new PageImpl<>(this.gradeDao.queryAll(),PageRequest.of(0,10),total);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param gradeId 主键
     * @return 实例对象
     */
    @Override
    public Grade queryById(Integer gradeId) {
        return this.gradeDao.queryById(gradeId);
    }

    /**
     * 分页查询
     *
     * @param grade       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Grade> queryByPage(Grade grade, PageRequest pageRequest) {
        long total = this.gradeDao.count(grade);
        return new PageImpl<>(this.gradeDao.queryAllByLimit(grade, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param grade 实例对象
     * @return 实例对象
     */
    @Override
    public Grade insert(Grade grade) {
        this.gradeDao.insert(grade);
        return grade;
    }

    /**
     * 修改数据
     *
     * @param grade 实例对象
     * @return 实例对象
     */
    @Override
    public Grade update(Grade grade) {
        this.gradeDao.update(grade);
        return this.queryById(grade.getGradeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param gradeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer gradeId) {
        return this.gradeDao.deleteById(gradeId) > 0;
    }
}
