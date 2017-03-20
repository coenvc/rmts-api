package model;

import javax.persistence.*;

@Entity
public class SocialLinks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String facebookLink;

    @Column
    private String linkedinLink;

    @Column
    private String twitterLink;

    public SocialLinks() {
    }

    public SocialLinks(String facebookLink, String linkedinLink, String twitterLink) {
        this.facebookLink = facebookLink;
        this.linkedinLink = linkedinLink;
        this.twitterLink = twitterLink;
    }
}
