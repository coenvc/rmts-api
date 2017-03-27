package model.status;

import model.Address;
import model.AddressBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressBuilderTest {

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

    @Test (expected = IllegalArgumentException.class)
    public void propertyIsNull_throwsException() {

        Address address = new AddressBuilder()
                .street("Enschotsestraat")
                .zipcode("5014DD")
                .city("Tilburg")
                .build();
    }
}
