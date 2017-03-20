package model;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String street;

    @Column
    private String houseNumber;

    @Column
    private String city;

    @Column
    private  String zipcode;

    public Address(String street, String houseNumber, String city, String zipcode) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.zipcode = zipcode;
    }

    public Address() {

    }

    //region Getters & Setters

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getId() {

        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    //endregion
}
