package service.prospect;

import model.Prospect;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.prospect.ProspectRepository;
import service.user.UserService;

import java.util.List;

import static org.junit.Assert.*;


public class DefaultProspectServiceTest {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private UserService service = appContext.getBean("testUserService", UserService.class);

    @Test
    public boolean insert(Prospect prospect) {
        return false;
    }

    @Test
    public List getAll() {
        return null;
    }

    @Test
    public Prospect find(int id) {
        return null;
    }
}