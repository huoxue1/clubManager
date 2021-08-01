package com.clubmg.service.impl;

import com.clubmg.dao.ChiefDao;
import com.clubmg.pojo.Attend;
import com.clubmg.pojo.Club;
import com.clubmg.pojo.Member;
import com.clubmg.service.ChiefService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("chiefService")
public class ChiefServiceImpl implements ChiefService {


    @Resource(name = "chiefDao")
    private ChiefDao chiefDao;

    @Override
    public Club getClubByAdminLimit(Long adminId) {
        return chiefDao.getClubByAdminLimit(adminId);
    }

    @Override
    public void allowJoin(Long applyUid, Long currentUid) {


    }

    @Override
    public void refuseQuit(Long applyUid, Long currentUit) {

    }
}
