package model;

public class SocialLinksBuilder {

    private String facebook;
    private String linkedin;
    private String twitter;

    public SocialLinksBuilder facebook(String facebook)
    {
        if(facebook.contains("")) {
            throw new NullPointerException();
        }
        this.facebook = facebook;
        return this;
    }

    public SocialLinksBuilder linkedin(String linkedin)
    {
        if(linkedin.contains("")) {
            throw new NullPointerException();
        }
        this.linkedin = linkedin;
        return this;
    }

    public SocialLinksBuilder twitter(String twitter)
    {
        if(twitter.contains("")) {
            throw new NullPointerException();
        }
        this.twitter = twitter;
        return this;
    }

    public SocialLinks build(){
        return new SocialLinks(facebook, linkedin, twitter);
    }
}
