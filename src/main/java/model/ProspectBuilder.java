package model;

public class ProspectBuilder {

    private String _name;
    private String _jobTitle;
    private String _phoneNumber;
    private String _emailAddress;
    private String _facebookLink;
    private String _linkedInLink;

    public ProspectBuilder name(String name) {
        if(name == null) {
            throw new NullPointerException();
        }
        this._name = name;
        return this;
    }

    public ProspectBuilder jobTitle(String jobTitle) {
        if(jobTitle == null) {
            throw new NullPointerException();
        }
        this._jobTitle = jobTitle;
        return this;
    }

    public ProspectBuilder phoneNumber(String phoneNumber) {
        if(phoneNumber == null) {
            throw new NullPointerException();
        }
        this._phoneNumber = phoneNumber;
        return this;
    }

    public ProspectBuilder emailAddress(String emailAddress) {
        if(emailAddress == null) {
            throw new NullPointerException();
        }
        this._emailAddress = emailAddress;
        return this;
    }

    public ProspectBuilder facebookLink(String facebookLink) {
        if(facebookLink == null) {
            throw new NullPointerException();
        }
        this._facebookLink = facebookLink;
        return this;
    }

    public ProspectBuilder linkedInLink(String linkedInLink) {
        if(linkedInLink == null) {
            throw new NullPointerException();
        }
        this._linkedInLink = linkedInLink;
        return this;
    }

    public Prospect build() {
        Prospect prospect = new Prospect(_name, _jobTitle, _phoneNumber, _emailAddress, _facebookLink, _linkedInLink);
        return prospect;
    }
}