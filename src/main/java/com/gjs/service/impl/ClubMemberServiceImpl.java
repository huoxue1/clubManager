package com.gjs.service.impl;

import com.gjs.entity.ClubMember;
import com.gjs.dao.ClubMemberDao;
import com.gjs.service.ClubMemberService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 社团成员记录(ClubMember)表服务实现类
 *
 * @author makejava
 * @since 2021-11-01 15:24:02
 */
@Service("clubMemberService")
public class ClubMemberServiceImpl implements ClubMemberService {
    @Resource
    private ClubMemberDao clubMemberDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ClubMember queryById(Integer id) {
        return this.clubMemberDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param clubMember 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ClubMember> queryByPage(ClubMember clubMember, PageRequest pageRequest) {
        long total = this.clubMemberDao.count(clubMember);
        return new PageImpl<>(this.clubMemberDao.queryAllByLimit(clubMember, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param clubMember 实例对象
     * @return 实例对象
     */
    @Override
    public ClubMember insert(ClubMember clubMember) {
        this.clubMemberDao.insert(clubMember);
        return clubMember;
    }

    /**
     * 修改数据
     *
     * @param clubMember 实例对象
     * @return 实例对象
     */
    @Override
    public ClubMember update(ClubMember clubMember) {
        this.clubMemberDao.update(clubMember);
        return this.queryById(clubMember.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.clubMemberDao.deleteById(id) > 0;
    }
}
