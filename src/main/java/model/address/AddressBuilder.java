package model.address;

public class AddressBuilder {

    private int id;
    private String street;
    private String houseNumber;
    private String city;
    private  String zipcode;

    public AddressBuilder id(int id) {
        this.id = id;
        return this;
    }

    public AddressBuilder street(String street) {
        this.street = street;
        return this;
    }

    public AddressBuilder houseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public AddressBuilder city(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder zipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public Address build() {
        checkProperties();
        return new Address(street, houseNumber, city, zipcode);
    }

    //region Helper methods
    private void checkProperties() {
        if (street == null) throw new IllegalArgumentException("No street specified.");
        if (houseNumber == null) throw new IllegalArgumentException("No houseNumber specified.");
        if (city == null) throw new IllegalArgumentException("No city specified.");
        if (zipcode == null) throw new IllegalArgumentException("No zipcode specified.");
    }
    //endregion
}
