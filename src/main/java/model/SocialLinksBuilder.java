package model;

public class SocialLinksBuilder {

    private String facebookLink;
    private String linkedinLink;
    private String twitterLink;

    public SocialLinksBuilder facebookLink(String facebookLink)
    {
        if(facebookLink.contains("")) {
            throw new NullPointerException();
        }
        this.facebookLink = facebookLink;
        return this;
    }

    public SocialLinksBuilder linkedinLink(String linkedinLink)
    {
        if(linkedinLink.contains("")) {
            throw new NullPointerException();
        }
        this.linkedinLink = linkedinLink;
        return this;
    }

    public SocialLinksBuilder twitterLink(String twitterLink)
    {
        if(twitterLink.contains("")) {
            throw new NullPointerException();
        }
        this.twitterLink = twitterLink;
        return this;
    }

    public SocialLinks build(){
        return new SocialLinks(facebookLink, linkedinLink, twitterLink);
    }
}
