package com.gjs.mapper;

import com.gjs.entity.Club;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description club
 * @author gjs
 * @date 2021-10-07
 */
@Mapper
@Repository
public interface ClubMapper {

    /**
     * 新增
     * @author gjs
     * @date 2021/10/07
     **/
    int insert(Club club);

    /**
     * 刪除
     * @author gjs
     * @date 2021/10/07
     **/
    int delete(int id);

    /**
     * 更新
     * @author gjs
     * @date 2021/10/07
     **/
    int update(Club club);

    /**
     * 查询 根据主键 id 查询
     * @author gjs
     * @date 2021/10/07
     **/
    Club load(int id);

    /**
     * 查询 分页查询
     * @author gjs
     * @date 2021/10/07
     **/
    List<Club> pageList(int offset,int pagesize);

    /**
     * 查询 分页查询 count
     * @author gjs
     * @date 2021/10/07
     **/
    int pageListCount(int offset,int pagesize);

}
