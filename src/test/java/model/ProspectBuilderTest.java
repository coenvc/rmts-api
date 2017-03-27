package model;

import model.*;
import model.status.Status;
import model.status.StatusCode;
import model.status.StatusFactory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ProspectBuilderTest {

    private Address address = new AddressBuilder()
            .street("Enschotsestraat")
            .houseNumber("111")
            .zipcode("5014DD")
            .city("Tilburg")
            .build();

    private Profession profession = new ProfessionBuilder()
            .name("CEO")
            .build();

    private SocialLinks links = new SocialLinksBuilder()
            .facebook("facebook.com/user123")
            .linkedin("linkedin.com/user123")
            .twitter("twitter.com/user123")
            .build();

    private Status status = new StatusFactory()
            .build(StatusCode.ACTIVE);

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void propertiesSetInRightOrderWithoutInfix_buildsCorrectly() {

        Prospect prospect = new ProspectBuilder()
                .firstName("Theo")
                .surName("Estpersoon")
                .address(address)
                .profession(profession)
                .phoneNumber("0612341234")
                .emailAddress("T.Estpersoon@Test.nl")
                .imageUrl("img/user.png")
                .socialLinks(links)
                .status(status)
                .build();

        assertEquals(prospect.getfirstName(), "Theo");
        assertEquals(prospect.getSurName(), "Estpersoon");
        assertEquals(prospect.getAddress(), address);
        assertEquals(prospect.getprofession(), profession);
        assertEquals(prospect.getphoneNumber(), "0612341234");
        assertEquals(prospect.getEmailAddress(), "T.Estpersoon@Test.nl");
        assertEquals(prospect.getImageUrl(), "img/user.png");
        assertEquals(prospect.getSocialLinks(), links);
        assertEquals(prospect.getstatus(), status);
    }

    @Test
    public void propertiesSetInRightOrderWithInfix_buildsCorrectly() {
        Prospect prospect = new ProspectBuilder()
                .firstName("Theo")
                .infix("van den")
                .surName("Estpersoon")
                .address(address)
                .profession(profession)
                .phoneNumber("0612341234")
                .emailAddress("T.Estpersoon@Test.nl")
                .imageUrl("img/user.png")
                .socialLinks(links)
                .status(status)
                .build();

        assertEquals(prospect.getfirstName(), "Theo");
        assertEquals(prospect.getInfix(), "van den");
        assertEquals(prospect.getSurName(), "Estpersoon");
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
                .firstName("Theo")
                .surName("Estpersoon")
                .build();

        assertEquals(prospect.getfirstName(), "Theo");
        assertEquals(prospect.getSurName(), "Estpersoon");
        assertEquals(prospect.getAddress(), address);
        assertEquals(prospect.getprofession(), profession);
        assertEquals(prospect.getphoneNumber(), "0612341234");
        assertEquals(prospect.getEmailAddress(), "T.Estpersoon@Test.nl");
        assertEquals(prospect.getImageUrl(), "img/user.png");
        assertEquals(prospect.getSocialLinks(), links);
        assertEquals(prospect.getstatus(), status);
    }

    @Test
    public void firstNameIsNull_throwsException() {

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("The ProspectBuilder did not receive a valid First Name.");

        Prospect prospect = new ProspectBuilder()
                .surName("Estpersoon")
                .address(address)
                .profession(profession)
                .phoneNumber("0612341234")
                .emailAddress("T.Estpersoon@Test.nl")
                .imageUrl("img/user.png")
                .socialLinks(links)
                .status(status)
                .build();
    }

    @Test
    public void surNameIsNull_throwsException() {

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("The ProspectBuilder did not receive a valid Surname.");

        Prospect prospect = new ProspectBuilder()
                .firstName("Theo")
                .address(address)
                .profession(profession)
                .phoneNumber("0612341234")
                .emailAddress("T.Estpersoon@Test.nl")
                .imageUrl("img/user.png")
                .socialLinks(links)
                .status(status)
                .build();
    }

    @Test
    public void professionIsNull_throwsException() {

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("The ProspectBuilder did not receive a valid Profession.Name.");

        Prospect prospect = new ProspectBuilder()
                .firstName("Theo")
                .surName("Estpersoon")
                .address(address)
                .profession(profession)
                .phoneNumber("0612341234")
                .emailAddress("T.Estpersoon@Test.nl")
                .imageUrl("img/user.png")
                .socialLinks(links)
                .status(status)
                .build();
    }

    @Test
    public void phoneNumberIsNull_throwsException() {
        Prospect prospect = new ProspectBuilder()
                .firstName("Theo")
                .surName("Estpersoon")
                .address(address)
                .profession(profession)
                .phoneNumber("0612341234")
                .emailAddress("T.Estpersoon@Test.nl")
                .imageUrl("img/user.png")
                .socialLinks(links)
                .status(status)
                .build();
    }

    @Test
    public void emailAddressIsNull_throwsException() {
        Prospect prospect = new ProspectBuilder()
                .firstName("Theo")
                .surName("Estpersoon")
                .address(address)
                .profession(profession)
                .phoneNumber("0612341234")
                .emailAddress("T.Estpersoon@Test.nl")
                .imageUrl("img/user.png")
                .socialLinks(links)
                .status(status)
                .build();
    }

    @Test
    public void statusIsNull_throwsException() {
        Prospect prospect = new ProspectBuilder()
                .firstName("Theo")
                .surName("Estpersoon")
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
