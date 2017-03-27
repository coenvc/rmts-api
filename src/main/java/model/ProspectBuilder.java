package model;

import model.status.Status;
import model.status.StatusCode;
import model.status.StatusFactory;

public class ProspectBuilder {

    private String name;
    private Address address;
    private Profession profession;
    private String phoneNumber;
    private String emailAddress;
    private SocialLinks socialLinks;
    private Status status;

    public ProspectBuilder name(String name) {
        this.name = name;
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
            return new Prospect(name, address, profession, phoneNumber, emailAddress, socialLinks, status);
        }
        return null;
    }

    private boolean checkProperties() {
        if (name.equals("") || name == null) {
            System.out.println("The ProspectBuilder did not receive a valid Name.");
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

        if(status.getContent().equals("") || status == null){
            System.out.println("The ProspectBuilder did not receive a valid Status.Content");
            System.out.println("The default status has been assigned instead. It is not ");
            status(new StatusFactory().build(StatusCode.ACTIVE));
        }

        return true;
    }
}