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
    }
}
