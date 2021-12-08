package com.gjs.service;

import com.gjs.entity.ClubMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 社团成员记录(ClubMember)表服务接口
 *
 * @author makejava
 * @since 2021-11-01 15:24:02
 */
public interface ClubMemberService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClubMember queryById(Integer id);

    /**
     * 分页查询
     *
     * @param clubMember 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ClubMember> queryByPage(ClubMember clubMember, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param clubMember 实例对象
     * @return 实例对象
     */
    ClubMember insert(ClubMember clubMember);

    /**
     * 修改数据
     *
     * @param clubMember 实例对象
     * @return 实例对象
     */
    ClubMember update(ClubMember clubMember);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
