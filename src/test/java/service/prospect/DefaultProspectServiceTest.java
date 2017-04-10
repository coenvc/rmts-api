package service.prospect;

import model.*;
import model.status.StatusCode;
import model.status.StatusFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.prospect.ProspectRepository;
import service.user.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class DefaultProspectServiceTest {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private ProspectService service = appContext.getBean("testProspectService", ProspectService.class);

    @Test
    public void insert() throws Exception {
    }

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

    @Test
    public void updateProspect_GivenObject_ReturnsTrue() throws Exception{

        Prospect p1 = new ProspectBuilder()
                .firstName("Henk")
                .infix("van de")
                .surName("Koning")
                .phoneNumber("0612345678")
                .emailAddress("HenkvandeKoning@gmail.com")
                .imageUrl("Google.com")
                .description("Goede vent!")
                .address(new AddressBuilder()
                        .street("Kerkstraat")
                        .houseNumber("10")
                        .city("Tilburg")
                        .zipcode("5032HJ")
                        .build())
                .profession(new ProfessionBuilder()
                        .name("Bankzitter")
                        .build())
                .socialLinks(new SocialLinksBuilder()
                        .facebook("")
                        .linkedin("")
                        .twitter("")
                        .build())
                .status(new StatusFactory()
                        .build(StatusCode.ACTIVE))
                .build();
        boolean result = service.update(p1);
        assertTrue(result);

    }

    @Test
    public void updateProspect_GivenNull_ReturnsFalse() throws Exception{

        boolean result2 = service.update(null);
        assertFalse(result2);
    }
}