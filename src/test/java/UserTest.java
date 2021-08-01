import com.clubmg.controller.UserBaseController;
import com.clubmg.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
public class UserTest {

    @Resource
    private UserBaseController userBaseController;

    @Resource
    private SessionFactory sessionFactory;

    public void getUser(){
        Session session = sessionFactory.getCurrentSession();
    }

    @Test
    public void getAll(){
        List<User> allUser = userBaseController.getAll();
        for (User user : allUser) {
            System.out.println(user);
        }

    }

    @Test
    public void singUp(){
        User u = new User();
        u.setAccount(123);
        u.setPassword("12345");
        u.setName("A");
        //userController.singUp(u);
    }
}
