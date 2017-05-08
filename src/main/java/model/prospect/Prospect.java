package model.prospect;

import model.Crudable;
import model.socialLinks.SocialLinks;
import model.address.Address;
import model.profession.Profession;
import model.status.Status;
import utility.StringCombiner;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Prospect implements Crudable {

    // Complex types
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Address.class, fetch = FetchType.EAGER)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Profession.class, fetch = FetchType.EAGER)
    @JoinColumn
    private Profession profession;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = SocialLinks.class, fetch = FetchType.EAGER)
    @JoinColumn
    private SocialLinks socialLinks;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Status.class, fetch = FetchType.EAGER)
    @JoinColumn
    private Status status;

    // Basic types
    private String firstName;
    private String infix;
    private String surname;
    private String fullName;
    private String phoneNumber;
    private String emailAddress;
    private String imageUrl;
    private String description;

    public Prospect() {

    }

    public Prospect(String firstName, String infix, String surname, Address address, Profession profession, String phoneNumber, String emailAddress, String imageUrl, String description, SocialLinks socialLinks, Status status) {
        this.firstName = firstName;
        this.infix = infix;
        this.surname = surname;
        this.address = address;
        this.profession = profession;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.imageUrl = imageUrl;
        this.description = description;
        this.socialLinks = socialLinks;
        this.status = status;
    }


    public boolean isIncomplete() {
        return emailAddress == null ||
                firstName == null ||
                surname == null ||
                profession.isIncomplete() ||
                status.isIncomplete();
    }

    public List<String> getIncompleteProperties() {
        List<String> list = new ArrayList<String>();

        if (emailAddress == null) list.add("emailAddress");
        if (firstName == null) list.add("firstName");
        if (phoneNumber == null) list.add("phoneNumber");
        if (surname == null) list.add("surname");
        if (profession != null && profession.isIncomplete()) list.add("nested object 'profession' is incomplete, missing " + StringCombiner.combineList(profession.getIncompleteProperties()));
        if (profession == null) list.add("profession");
        if (status != null && status.isIncomplete()) list.add("nested object 'status' is incomplete, missing " + StringCombiner.combineList(status.getIncompleteProperties()));
        if (status == null) list.add("status");

        return list;
    }

    //region Getters & Setters

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surName) {
        this.surname = surName;
    }

    public String getInfix() {
        return infix;
    }

    public void setInfix(String infix) {
        this.infix = infix;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public Profession getprofession() {
        return profession;
    }

    public void setprofession(Profession profession) {
        this.profession = profession;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SocialLinks getSocialLinks() {
        return socialLinks;
    }

    public void setSocialLinks(SocialLinks socialLinks) {
        this.socialLinks = socialLinks;
    }

    public Status getstatus() {
        return status;
    }

    public void setstatus(Status status) {
        this.status = status;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullName() {
        return firstName + " " + infix + " " + surname;
    }

    //endregion
}