package model.status;

import model.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProspectBuilderTest {

    Address address = new AddressBuilder()
            .street("Enschotsestraat")
            .houseNumber("111")
            .zipcode("5014DD")
            .city("Tilburg")
            .build();

    Profession profession = new ProfessionBuilder()
            .name("CEO")
            .build();

    SocialLinks links = new SocialLinksBuilder()
            .facebook("facebook.com/user123")
            .linkedin("linkedin.com/user123")
            .twitter("twitter.com/user123")
            .build();

    Status status = new StatusFactory()
            .build(StatusCode.ACTIVE);

    @Test
    public void propertiesSetInRightOrder_buildsCorrectly() {

        Prospect prospect = new ProspectBuilder()
                .name("Theo Estpersoon")
                .address(address)
                .profession(profession)
                .phoneNumber("0612341234")
                .emailAddress("T.Estpersoon@Test.nl")
                .imageUrl("img/user.png")
                .socialLinks(links)
                .status(status)
                .build();

        assertEquals(prospect.getfirstName(), "Theo");
        assertEquals(prospect.getAddress(), address);
        assertEquals(prospect.getprofession(), profession);
        assertEquals(prospect.getphoneNumber(), "0612341234");
        assertEquals(prospect.getEmailAddress(), "T.Estpersoon@Test.nl");
        assertEquals(prospect.getImageUrl(), "img/user.png");
        assertEquals(prospect.getSocialLinks(), links);
        assertEquals(prospect.getstatus(), status);
    }

    @Test
    public void propertiesSetInRandomOrder_buildsCorrectly() {

        Prospect prospect = new ProspectBuilder()
                .profession(profession)
                .imageUrl("img/user.png")
                .status(status)
                .socialLinks(links)
                .emailAddress("T.Estpersoon@Test.nl")
                .address(address)
                .phoneNumber("0612341234")
                .name("Theo Estpersoon")
                .build();

        assertEquals(prospect.getfirstName(), "Theo");
        assertEquals(prospect.getAddress(), address);
        assertEquals(prospect.getprofession(), profession);
        assertEquals(prospect.getphoneNumber(), "0612341234");
        assertEquals(prospect.getEmailAddress(), "T.Estpersoon@Test.nl");
        assertEquals(prospect.getImageUrl(), "img/user.png");
        assertEquals(prospect.getSocialLinks(), links);
        assertEquals(prospect.getstatus(), status);
    }
}
