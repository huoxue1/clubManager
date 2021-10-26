package com.gjs.service.impl;

import com.gjs.entity.Club;
import com.gjs.entity.H;
import com.gjs.mapper.ClubMapper;
import com.gjs.service.ClubService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description club
 * @author gjs
 * @date 2021-10-07
 */
@Service
public class ClubServiceImpl implements ClubService {

    @Resource
    private ClubMapper clubMapper;


    @Override
    public Object insert(Club club) {

        // valid
        if (club == null) {
            return H.error("必要参数缺失");
        }

        clubMapper.insert(club);
        return H.success();
    }


    @Override
    public Object delete(int id) {
        int ret = clubMapper.delete(id);
        return ret>0?H.success():H.error();
    }


    @Override
    public Object update(Club club) {
        int ret = clubMapper.update(club);
        return ret>0?H.success():H.error();
    }


    @Override
    public Club load(int id) {
        return clubMapper.load(id);
    }


    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {

        List<Club> pageList = clubMapper.pageList(offset, pagesize);
        int totalCount = clubMapper.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return result;
    }

}