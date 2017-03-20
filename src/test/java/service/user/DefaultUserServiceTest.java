package service.user;

import model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;


public class DefaultUserServiceTest {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private UserService service = appContext.getBean("testUserService", UserService.class);

    @Test
    public void getAll() throws Exception {
        List users = service.getAll();
        assertEquals(2, users.size());
    }

    @Test
    public void find() throws Exception {
        User user = service.find(1);
        assertEquals(user.getId(), 1);
    }
}