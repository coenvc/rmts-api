package service.prospect;

import model.address.AddressBuilder;
import model.profession.ProfessionBuilder;
import model.prospect.Prospect;
import model.prospect.ProspectBuilder;
import model.socialLinks.SocialLinksBuilder;
import model.status.StatusCode;
import model.status.StatusFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;


public class DefaultProspectServiceTest {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private ProspectService service = appContext.getBean("testProspectService", ProspectService.class);


    @Test
    public void requestAllProspects_ReturnsList() throws Exception{
        List prospects = service.getAll();
        assertEquals(2, prospects.size());
    }

    @Test
    public void requestById_ReturnsCorrectProspect() throws Exception{
        Prospect prospect = service.find(1);
        assertEquals(prospect.getid(), 1);
    }

}