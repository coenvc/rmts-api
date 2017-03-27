package model;


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
                .description("Potentieel lid")
                .socialLinks(links)
                .status(status)
                .build();

        assertEquals(prospect.getfirstName(), "Theo");
        assertEquals(prospect.getSurname(), "Estpersoon");
        assertEquals(prospect.getAddress(), address);
        assertEquals(prospect.getprofession(), profession);
        assertEquals(prospect.getphoneNumber(), "0612341234");
        assertEquals(prospect.getEmailAddress(), "T.Estpersoon@Test.nl");
        assertEquals(prospect.getImageUrl(), "img/user.png");
        assertEquals(prospect.getDescription(), "Potentieel lid");
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
                .description("Potentieel lid")
                .socialLinks(links)
                .status(status)
                .build();

        assertEquals(prospect.getfirstName(), "Theo");
        assertEquals(prospect.getInfix(), "van den");
        assertEquals(prospect.getSurname(), "Estpersoon");
        assertEquals(prospect.getAddress(), address);
        assertEquals(prospect.getprofession(), profession);
        assertEquals(prospect.getphoneNumber(), "0612341234");
        assertEquals(prospect.getEmailAddress(), "T.Estpersoon@Test.nl");
        assertEquals(prospect.getImageUrl(), "img/user.png");
        assertEquals(prospect.getDescription(), "Potentieel lid");
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
                .description("Potentieel lid")
                .address(address)
                .phoneNumber("0612341234")
                .firstName("Theo")
                .surName("Estpersoon")
                .build();

        assertEquals(prospect.getfirstName(), "Theo");
        assertEquals(prospect.getSurname(), "Estpersoon");
        assertEquals(prospect.getAddress(), address);
        assertEquals(prospect.getprofession(), profession);
        assertEquals(prospect.getphoneNumber(), "0612341234");
        assertEquals(prospect.getEmailAddress(), "T.Estpersoon@Test.nl");
        assertEquals(prospect.getImageUrl(), "img/user.png");
        assertEquals(prospect.getDescription(), "Potentieel lid");
        assertEquals(prospect.getSocialLinks(), links);
        assertEquals(prospect.getstatus(), status);
    }

    @Test
    public void firstNameIsNull_throwsException() {

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("No first name provided");

        Prospect prospect = new ProspectBuilder()
                .firstName("")
                .surName("Estpersoon")
                .address(address)
                .profession(profession)
                .phoneNumber("0612341234")
                .emailAddress("T.Estpersoon@Test.nl")
                .imageUrl("img/user.png")
                .description("Potentieel lid")
                .socialLinks(links)
                .status(status)
                .build();
    }

    @Test
    public void surNameIsNull_throwsException() {

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("No surname name provided");

        Prospect prospect = new ProspectBuilder()
                .firstName("Theo")
                .surName("")
                .address(address)
                .profession(profession)
                .phoneNumber("0612341234")
                .emailAddress("T.Estpersoon@Test.nl")
                .imageUrl("img/user.png")
                .description("Potentieel lid")
                .socialLinks(links)
                .status(status)
                .build();
    }

    @Test
    public void addressIsNull_throwsException() {

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("No address name provided");

        Prospect prospect = new ProspectBuilder()
                .firstName("Theo")
                .surName("Estpersoon")
                .profession(profession)
                .phoneNumber("0612341234")
                .emailAddress("T.Estpersoon@Test.nl")
                .imageUrl("img/user.png")
                .description("Potentieel lid")
                .socialLinks(links)
                .status(status)
                .build();
    }

    @Test
    public void professionIsNull_throwsException() {

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("No profession name provided");

        Prospect prospect = new ProspectBuilder()
                .firstName("Theo")
                .surName("Estpersoon")
                .address(address)
                .phoneNumber("0612341234")
                .emailAddress("T.Estpersoon@Test.nl")
                .imageUrl("img/user.png")
                .description("Potentieel lid")
                .socialLinks(links)
                .status(status)
                .build();
    }

    @Test
    public void phoneNumberIsNull_throwsException() {

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("No phone number provided");

        Prospect prospect = new ProspectBuilder()
                .firstName("Theo")
                .surName("Estpersoon")
                .address(address)
                .profession(profession)
                .phoneNumber("")
                .emailAddress("T.Estpersoon@Test.nl")
                .imageUrl("img/user.png")
                .description("Potentieel lid")
                .socialLinks(links)
                .status(status)
                .build();
    }

    @Test
    public void emailAddressIsNull_throwsException() {

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("No email address provided");

        Prospect prospect = new ProspectBuilder()
                .firstName("Theo")
                .surName("Estpersoon")
                .address(address)
                .profession(profession)
                .phoneNumber("0612341234")
                .emailAddress("")
                .imageUrl("img/user.png")
                .description("Potentieel lid")
                .socialLinks(links)
                .status(status)
                .build();
    }

    @Test
    public void descriptionIsNull_throwsException() {

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("No description provided");

        Prospect prospect = new ProspectBuilder()
                .firstName("Theo")
                .surName("Estpersoon")
                .address(address)
                .profession(profession)
                .phoneNumber("0612341234")
                .emailAddress("T.Estpersoon@Test.nl")
                .imageUrl("img/user.png")
                .description("")
                .socialLinks(links)
                .status(status)
                .build();
    }

    @Test
    public void socialLinksIsNull_throwsException() {

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("No social links provided");

        Prospect prospect = new ProspectBuilder()
                .firstName("Theo")
                .surName("Estpersoon")
                .address(address)
                .profession(profession)
                .phoneNumber("0612341234")
                .emailAddress("T.Estpersoon@Test.nl")
                .imageUrl("img/user.png")
                .description("Potentieel lid")
                .status(status)
                .build();
    }

    @Test
    public void statusIsNull_throwsException() {

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("No status provided");

        Prospect prospect = new ProspectBuilder()
                .firstName("Theo")
                .surName("Estpersoon")
                .address(address)
                .profession(profession)
                .phoneNumber("0612341234")
                .emailAddress("T.Estpersoon@Test.nl")
                .imageUrl("img/user.png")
                .description("Potentieel lid")
                .socialLinks(links)
                .build();
    }
}
