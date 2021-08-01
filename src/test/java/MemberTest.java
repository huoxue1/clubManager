import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MemberTest {
    @Resource
    private SessionFactory sessionFactory;

    @Test
    public void query(){
        Session session = sessionFactory.openSession();
        long cid=1;
        String hql = "select c.state from Club c where c.cid = ?1";
        Query<Integer> query = session.createQuery(hql);
        query.setParameter(1,cid);
        Integer state= query.uniqueResult();
        System.out.println(state);

    }
}
