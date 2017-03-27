package model;

import model.status.Status;
import model.status.StatusCode;
import model.status.StatusFactory;

public class ProspectBuilder {

    private String firstName;
    private String infix;
    private String surName;
    private Address address;
    private Profession profession;
    private String phoneNumber;
    private String emailAddress;
    private String imageUrl;
    private String description;
    private SocialLinks socialLinks;
    private Status status;

    public ProspectBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ProspectBuilder infix(String infix) {
        this.infix = infix;
        return this;
    }

    public ProspectBuilder surName(String surname) {
        this.surName = surname;
        return this;
    }

    public ProspectBuilder emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public ProspectBuilder address(Address address) {
        this.address = address;
        return this;
    }

    public ProspectBuilder imageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public ProspectBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ProspectBuilder profession(Profession profession) {
        this.profession = profession;
        return this;
    }

    public ProspectBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ProspectBuilder socialLinks(SocialLinks socialLinks) {
        this.socialLinks = socialLinks;
        return this;
    }

    public ProspectBuilder status(Status status) {
        this.status = status;
        return this;
    }

    public Prospect build() {
        if (checkProperties()) {
            return new Prospect(firstName, infix, surName, address, profession, phoneNumber, emailAddress, imageUrl, description, socialLinks, status);
        }
        return null;
    }

    private boolean checkProperties() {
        if (firstName.equals("") || firstName == null) {
            System.out.println("The ProspectBuilder did not receive a valid First Name.");
            return false;
        }

        if (surName.equals("") || surName == null) {
            System.out.println("The ProspectBuilder did not receive a valid Surname.");
            return false;
        }

        if (emailAddress.equals("") || emailAddress == null) {
            System.out.println("The ProspectBuilder did not receive a valid Email Address.");
            return false;
        }

        if (profession.getName().equals("") || profession == null) {
            System.out.println("The ProspectBuilder did not receive a valid Profession.Name.");
            return false;
        }

        if (status.getContent().equals("") || status == null) {
            System.out.println("The ProspectBuilder did not receive a valid Status.Content");
            System.out.println("The default status has been assigned instead. It is not ");
            status(new StatusFactory().build(StatusCode.ACTIVE));
        }

        return true;
    }
}