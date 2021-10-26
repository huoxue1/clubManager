package com.gjs.service;

import com.gjs.entity.Club;

import java.util.Map;
/**
 * @description club
 * @author gjs
 * @date 2021-10-07
 */
public interface ClubService {

    /**
     * 新增
     */
    public Object insert(Club club);

    /**
     * 删除
     */
    public Object delete(int id);

    /**
     * 更新
     */
    public Object update(Club club);

    /**
     * 根据主键 id 查询
     */
    public Club load(int id);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

}