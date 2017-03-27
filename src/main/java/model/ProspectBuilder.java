package model;

import model.status.Status;

public class ProspectBuilder {

    private int id;
    private String name;
    private Address address;
    private Profession profession;
    private String phoneNumber;
    private String emailAddress;
    private String imageUrl;
    private SocialLinks socialLinks;
    private Status status;

    public ProspectBuilder name(String name) {
        if(name == null) {
            throw new NullPointerException();
        }
        this.name = name;
        return this;
    }

    public ProspectBuilder emailAddress(String emailAddress){
        if(emailAddress == null){
            throw new NullPointerException();
        }
        this.emailAddress = emailAddress;
        return this;
    }

    public ProspectBuilder address(Address address) {
        if (address == null) {
            throw new NullPointerException();
        }
        this.address = address;
        return this;
    }

    public ProspectBuilder profession(Profession profession) {
        if(profession == null) {
            throw new NullPointerException();
        }
        this.profession = profession;
        return this;
    }

    public ProspectBuilder phoneNumber(String phoneNumber) {
        if(phoneNumber == null) {
            throw new NullPointerException();
        }
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ProspectBuilder imageUrl(String imageUrl) {

        if (imageUrl == null) {
            throw new NullPointerException();
        }
        this.imageUrl = imageUrl;
        return this;
   }

    public ProspectBuilder socialLinks(SocialLinks socialLinks) {
        if(socialLinks == null) {
            throw new NullPointerException();
        }
        this.socialLinks = socialLinks;
        return this;
    }

    public ProspectBuilder status(Status status) {
        if(status == null) {
            throw new NullPointerException();
        }
        this.status = status;
        return this;
    }

    public Prospect build() {
        return new Prospect(name, address, profession, phoneNumber, emailAddress, socialLinks, status, imageUrl);
    }
}