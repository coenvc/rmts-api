package model;

public class SocialLinksBuilder {

    private String facebook = "";
    private String linkedin = "";
    private String twitter = "";

    public SocialLinksBuilder facebook(String facebook)
    {
        this.facebook = facebook;
        return this;
    }

    public SocialLinksBuilder linkedin(String linkedin)
    {
        this.linkedin = linkedin;
        return this;
    }

    public SocialLinksBuilder twitter(String twitter)
    {

        this.twitter = twitter;
        return this;
    }

    public SocialLinks build(){
        return new SocialLinks(facebook, linkedin, twitter);
    }
}
