package model.socialLinks;

import model.Crudable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SocialLinks implements Crudable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String facebook;
    private String linkedIn;
    private String twitter;

    public SocialLinks() {

    }

    public SocialLinks(String facebookLink, String linkedinLink, String twitterLink) {
        this.facebook = facebookLink;
        this.linkedIn = linkedinLink;
        this.twitter = twitterLink;
    }

    public boolean isIncomplete() {
        return facebook == null ||
                linkedIn == null ||
                twitter == null;
    }

    public List<String> getIncompleteProperties() {
        List<String> list = new ArrayList<String>();

        if (facebook == null) list.add("facebook");
        if (linkedIn == null) list.add("linkedIn");
        if (twitter == null) list.add("twitter");

        return list;
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

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkdIn) {
        this.linkedIn = linkdIn;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }


    //endregion
}
