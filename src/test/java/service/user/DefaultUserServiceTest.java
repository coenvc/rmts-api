package service.user;

import model.user.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;


public class DefaultUserServiceTest {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private UserService service = appContext.getBean("testUserService", UserService.class);

    @Test
    public void requestAllUsers_ReturnsList() throws Exception {
        List users = service.getAll();
        assertEquals(2, users.size());
    }

    @Test
    public void requestById_ReturnsCorrectUser() throws Exception {
        User user = service.find(1);
        assertEquals(user.getId(), 1);
    }

    @Test
    public void requestLogin_ReturnsUser() throws Exception{
        User user = service.login("T.est", "Hallo");
        assertEquals(user.getName(), "Teun Est");
    }
}