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

    @Test
    public void deleteStatus_GivenObject_ReturnsTrue() throws Exception{
        Status status = new Status("Test");
        status.setId(1);
        boolean result = service.delete(status);
        assertTrue(result);
    }

    @Test
    public void deleteStatus_GivenNull_ReturnsFalse() throws Exception{
        Status status = new Status("Test");
        status.setId(1);
        boolean result2 = service.delete(null);
        assertFalse(result2);
    }

    @Test
    public void updateStatus_GivenObject_ReturnsTrue() throws Exception{
        Status status = new Status("Test");
        status.setId(1);
        boolean result = service.update(status);
        assertTrue(result);
    }

    @Test
    public void updateStatus_GivenNull_ReturnsFalse() throws Exception{
        Status status = new Status("Test");
        status.setId(1);
        boolean result2 = service.update(null);
        assertFalse(result2);
    }

    @Test
    public void insertStatus_GivenObject_ReturnsTrue() throws Exception{
        Status status = new Status("Test");
        status.setId(1);
        boolean result = service.insert(status);
        assertTrue(result);
    }

    @Test
    public void insertStatus_GivenNull_ReturnsFalse() throws Exception{
        Status status = new Status("Test");
        status.setId(1);
        boolean result2 = service.insert(null);
        assertFalse(result2);
    }

}
