package com.clubmg.dao.impl;

import com.clubmg.dao.ChiefDao;
import com.clubmg.pojo.Club;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("chiefDao")
public class ChiefDaoImpl implements ChiefDao {
    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Club getClubByAdminLimit(Long adminId) {
        String hql = "from Club c where c.cid = (select m.cid from Member m where m.uid= ?1 and m.permit=1)";
        Query<Club> query = getSession().createQuery(hql);
        query.setParameter(1, adminId);
        return query.uniqueResult();
    }

}
