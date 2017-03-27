package model;

import model.Address;
import model.AddressBuilder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class AddressBuilderTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void propertiesSetInRightOrder_buildsCorrectly() {

        Address address = new AddressBuilder()
                .street("Enschotsestraat")
                .houseNumber("111")
                .zipcode("5014DD")
                .city("Tilburg")
                .build();

        assertEquals(address.getStreet(), "Enschotsestraat");
        assertEquals(address.getHouseNumber(), "111");
        assertEquals(address.getZipcode(), "5014DD");
        assertEquals(address.getCity(), "Tilburg");
    }

    @Test
    public void propertiesSetInRandomOrder_buildsCorrectly() {

        Address address = new AddressBuilder()
                .zipcode("5014DD")
                .street("Enschotsestraat")
                .city("Tilburg")
                .houseNumber("111")
                .build();

        assertEquals(address.getStreet(), "Enschotsestraat");
        assertEquals(address.getHouseNumber(), "111");
        assertEquals(address.getZipcode(), "5014DD");
        assertEquals(address.getCity(), "Tilburg");
    }

    @Test
    public void streetIsNull_throwsException() {

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("No street specified.");

        Address address = new AddressBuilder()
                .houseNumber("111")
                .zipcode("5014DD")
                .city("Tilburg")
                .build();
    }

    @Test
    public void houseNumberIsNull_throwsException() {

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("No houseNumber specified.");

        Address address = new AddressBuilder()
                .street("Enschotsestraat")
                .zipcode("5014DD")
                .city("Tilburg")
                .build();
    }

    @Test
    public void cityIsNull_throwsException() {

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("No city specified.");

        Address address = new AddressBuilder()
                .street("Enschotsestraat")
                .houseNumber("111")
                .zipcode("5014DD")
                .build();
    }

    @Test
    public void zipcodeIsNull_throwsException() {

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("No zipcode specified.");

        Address address = new AddressBuilder()
                .street("Enschotsestraat")
                .houseNumber("111")
                .city("Tilburg")
                .build();
    }
}
