package com.clubmg.dao.impl;

import com.clubmg.dao.UserDao;
import com.clubmg.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<User> getAll() {
        String hql = "from User";
        return getSession().createQuery(hql).list();
    }

    @Override
    public List<User> getUser(long uid) {
        String hql = "FROM User u where u.uid=?1";
        Query<User> query = getSession().createQuery(hql);
        query.setParameter(1, uid);
        return query.list();
    }

    @Override
    public List<User> getUser(Long account, String password) {
        String hql = "FROM User u where u.account=?1 and u.password=?2";
        Query<User> query = getSession().createQuery(hql);
        query.setParameter(1, account);
        query.setParameter(2, password);
        return query.list();
    }

    @Override
    public void singUp(User user){
        getSession().save(user);
    }

}
