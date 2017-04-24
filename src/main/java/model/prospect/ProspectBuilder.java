package model.prospect;

import model.socialLinks.SocialLinks;
import model.address.Address;
import model.profession.Profession;
import model.status.Status;

public class ProspectBuilder {

    private String firstName;
    private String infix;
    private String surname;
    private Address address;
    private Profession profession;
    private String phoneNumber;
    private String emailAddress;
    private String imageUrl = "http://www.pieglobal.com/wp-content/uploads/2015/10/placeholder-user.png";
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
        this.surname = surname;
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
        checkProperties();
        return new Prospect(firstName, infix, surname, address, profession, phoneNumber, emailAddress, imageUrl, description, socialLinks, status);
    }

    private void checkProperties() {
        if (firstName.equals("")) throw new IllegalArgumentException("No first name provided");
        if (surname.equals("")) throw new IllegalArgumentException("No surname name provided");
        if (address == null) throw new IllegalArgumentException("No address name provided");
        if (profession == null) throw new IllegalArgumentException("No profession name provided");
        if (phoneNumber.equals("")) throw new IllegalArgumentException("No phone number provided");
        if (emailAddress.equals("")) throw new IllegalArgumentException("No email address provided");
        if (description.equals("")) throw new IllegalArgumentException("No description provided");
        if (socialLinks == null) throw new IllegalArgumentException("No social links provided");
        if (status == null) throw new IllegalArgumentException("No status provided");
    }
}