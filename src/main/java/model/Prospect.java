package model;

import javax.persistence.*;

@Entity
public class Prospect {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _id;

    @Column
	private String _name;

    @Column
	private String _jobTitle;

    @Column
	private String _phoneNumber;

    @Column
	private String _emailAddress;

    @Column
	private String _facebookLink;

    @Column
	private String _linkedInLink;

	public Prospect(String name, String jobTitle, String phoneNumber, String emailAddress, String facebookLink, String linkedInLink) {
	    _name = name;
	    _jobTitle = jobTitle;
	    _phoneNumber = phoneNumber;
	    _emailAddress = emailAddress;
	    _facebookLink = facebookLink;
	    _linkedInLink = linkedInLink;
    }

    public Prospect() {

    }

	//region Getters & Setters
    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_jobTitle() {
        return _jobTitle;
    }

    public void set_jobTitle(String _jobTitle) {
        this._jobTitle = _jobTitle;
    }

    public String get_phoneNumber() {
        return _phoneNumber;
    }

    public void set_phoneNumber(String _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }

    public String get_emailAddress() {
        return _emailAddress;
    }

    public void set_emailAddress(String _emailAddress) {
        this._emailAddress = _emailAddress;
    }

    public String get_facebookLink() {
        return _facebookLink;
    }

    public void set_facebookLink(String _facebookLink) {
        this._facebookLink = _facebookLink;
    }

    public String get_linkedInLink() {
        return _linkedInLink;
    }

    public void set_linkedInLink(String _linkedInLink) {
        this._linkedInLink = _linkedInLink;
    }
    //endregion
}