package model;

public class ProspectBuilder {

    /* TODO
     * Composition toepassen met de volgende classes: Job, Address, SocialLinks
    */
    private String name;
    private String profession;
    private String phoneNumber;
    private SocialLinks socialLinks;
    private Status status;

    public ProspectBuilder name(String name) {
        if(name == null) {
            throw new NullPointerException();
        }
        this.name = name;
        return this;
    }

    public ProspectBuilder profession(String profession) {
        if(profession == null) {
            throw new NullPointerException();
        }
        this.profession = profession;
        return this;
    }

    public ProspectBuilder phoneNumber(String phoneNumber) {
        if(phoneNumber == null) {
            throw new NullPointerException();
        }
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ProspectBuilder socialLinks(SocialLinks socialLinks) {
        if(socialLinks == null) {
            throw new NullPointerException();
        }
        this.socialLinks = socialLinks;
        return this;
    }

    public ProspectBuilder status(Status status) {
        if(status == null) {
            throw new NullPointerException();
        }
        this.status = status;
        return this;
    }

    public Prospect build() {
        return new Prospect(name, profession, phoneNumber, socialLinks, status);
    }
}