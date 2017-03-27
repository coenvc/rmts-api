package model;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class SocialLinksBuilderTest {

    @Test
    public void buildNewSocialLinkWithValues_HasValues() throws Exception {
        SocialLinks socialLinks = new SocialLinksBuilder()
                .facebook("Facebook.com")
                .linkedin("Linkedin.com")
                .twitter("Twitter.com")
                .build();

        assertEquals(socialLinks.getFacebook(), "Facebook.com");
        assertEquals(socialLinks.getLinkedIn(), "Linkedin.com");
        assertEquals(socialLinks.getTwitter(), "Twitter.com");
    }

    @Test
    public void buildNewSocialLinkWithoutValues_NoValues() throws Exception {
        SocialLinks socialLinks = new SocialLinksBuilder()
                .build();

        assertEquals(socialLinks.getFacebook(), "");
        assertEquals(socialLinks.getLinkedIn(), "");
        assertEquals(socialLinks.getTwitter(), "");
    }
}