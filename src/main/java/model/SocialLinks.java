package model;

import javax.persistence.*;

@Entity
public class SocialLinks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String facebook;

    @Column
    private String linkdIn;

    @Column
    private String twitter;

    public SocialLinks() {

    }

    public SocialLinks(String facebookLink, String linkedinLink, String twitterLink) {
        this.facebook = facebookLink;
        this.linkdIn = linkedinLink;
        this.twitter = twitterLink;
    }

    //region Getters & Setters

    public int getId() {
        return id;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkdIn() {
        return linkdIn;
    }

    public void setLinkdIn(String linkdIn) {
        this.linkdIn = linkdIn;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    //endregion
}
