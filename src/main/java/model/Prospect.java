package model;

import model.status.Status;

import javax.persistence.*;

@Entity
public class Prospect {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    @OneToOne(targetEntity = Profession.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Profession profession;

    @Column
    private String phoneNumber;

    @Column
    private String emailAddress;

    @OneToOne(targetEntity = SocialLinks.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private SocialLinks socialLinks;

    @ManyToOne(targetEntity = Status.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Status status;

    public Prospect() {

    }

    public Prospect(String name, Address address, Profession profession, String phoneNumber, String emailAddress, SocialLinks socialLinks, Status status) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.address = address;
        this.profession = profession;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.socialLinks = socialLinks;
        this.status = status;
    }

//region Getters & Setters
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

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
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
    //endregion
}