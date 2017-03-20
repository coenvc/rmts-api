package model;

import javax.persistence.*;

@Entity
public class Prospect {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String profession;

    @Column
    private String phoneNumber;

    @Column
    @OneToMany(targetEntity = SocialLinks.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private SocialLinks socialLinks;

    @OneToMany(targetEntity = Status.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Status status;

    public Prospect() {

    }

    public Prospect(String name, String profession, String phoneNumber, SocialLinks socialLinks, Status status) {
        this.name = name;
        this.profession = profession;
        this.phoneNumber = phoneNumber;
        this.socialLinks = socialLinks;
        this.status = status;
    }

    //region Getters & Setters
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

    public String getprofession() {
        return profession;
    }

    public void setprofession(String profession) {
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
    //endregion
}