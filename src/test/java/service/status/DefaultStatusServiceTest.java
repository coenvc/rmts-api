package service.status;


import model.status.Status;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class DefaultStatusServiceTest {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private StatusService service = appContext.getBean("testStatusService", StatusService.class);


    @Test
    public void requestAllStatuses_ReturnsList() throws Exception{
        List statusList = service.getAll();
        assertEquals(10, statusList.size());
    }

    @Test
    public void requestFindStatus_ReturnsStatusById() throws Exception{
        Status status = service.find(1);
        assertEquals(1, status.getId());
    }
}
