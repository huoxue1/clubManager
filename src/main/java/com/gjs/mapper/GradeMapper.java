package com.gjs.mapper;

import com.gjs.entity.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description grade
 * @author zhengkai.blog.csdn.net
 * @date 2021-10-04
 */
@Mapper
@Repository
public interface GradeMapper {

    /**
     * 新增
     * @author zhengkai.blog.csdn.net
     * @date 2021/10/04
     **/
    int insert(Grade grade);

    /**
     * 刪除
     * @author zhengkai.blog.csdn.net
     * @date 2021/10/04
     **/
    int delete(int id);

    /**
     * 更新
     * @author zhengkai.blog.csdn.net
     * @date 2021/10/04
     **/
    int update(Grade grade);

    /**
     * 查询 根据主键 id 查询
     * @author zhengkai.blog.csdn.net
     * @date 2021/10/04
     **/
    Grade load(int id);

    /**
     * 查询 分页查询
     * @author zhengkai.blog.csdn.net
     * @date 2021/10/04
     **/
    List<Grade> pageList(int offset,int pagesize);

    /**
     * 查询 分页查询 count
     * @author zhengkai.blog.csdn.net
     * @date 2021/10/04
     **/
    int pageListCount(int offset,int pagesize);

}
