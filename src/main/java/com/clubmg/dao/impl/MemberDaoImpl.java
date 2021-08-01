package com.clubmg.dao.impl;

import com.clubmg.dao.MemberDao;
import com.clubmg.pojo.Attend;
import com.clubmg.pojo.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public int getClubById(Long cid) {
        String hql = "select c.state from Club c where c.cid = ?1";
        Query<Integer> query = getSession().createQuery(hql);
        query.setParameter(1, cid);
        return query.uniqueResult();
    }

    @Override
    public Member getMemberInfoByTwoKey(Long uid, Long cid) {
        String hql = "from Member m where m.uid =?1 and m.cid=?2";
        Query<Member> query = getSession().createQuery(hql);
        query.setParameter(1, uid);
        query.setParameter(2, cid);
        return query.uniqueResult();
    }

    @Override
    public void joinClub(Member member) {
        getSession().save(member);
    }

    @Override
    public void UpdateApply(Member newMemberInfo) {
        getSession().update(newMemberInfo);
    }

    @Override
    public void attendActivity(Attend attend) {
        getSession().save(attend);
    }


}
