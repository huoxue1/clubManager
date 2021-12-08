package com.gjs.service.impl;

import com.gjs.entity.Club;
import com.gjs.dao.ClubDao;
import com.gjs.service.ClubService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 社团(Club)表服务实现类
 *
 * @author makejava
 * @since 2021-11-01 14:48:21
 */
@Service("clubService")
public class ClubServiceImpl implements ClubService {
    @Resource
    private ClubDao clubDao;

    @Override
    public List<Club> queryManagerClubs(Integer userId) {
        return clubDao.queryManagerClubs(userId);
    }

    @Override
    public List<Club> queryByState(Integer state) {
        return clubDao.queryByState(state);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param clubId 主键
     * @return 实例对象
     */
    @Override
    public Club queryById(Integer clubId) {
        return this.clubDao.queryById(clubId);
    }

    /**
     * 分页查询
     *
     * @param club        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Club> queryByPage(Club club, PageRequest pageRequest) {
        long total = this.clubDao.count(club);
        return new PageImpl<>(this.clubDao.queryAllByLimit(club, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param club 实例对象
     * @return 实例对象
     */
    @Override
    public Club insert(Club club) {
        this.clubDao.insert(club);
        return club;
    }

    /**
     * 修改数据
     *
     * @param club 实例对象
     * @return 实例对象
     */
    @Override
    public Club update(Club club) {
        this.clubDao.update(club);
        return this.queryById(club.getClubId());
    }

    /**
     * 通过主键删除数据
     *
     * @param clubId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer clubId) {
        return this.clubDao.deleteById(clubId) > 0;
    }
}
