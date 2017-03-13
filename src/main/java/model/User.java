package model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _id;

    @Column
    private String _username;

    @Column
    private String _password;

    @Column
    private String _name;

    @Column
    private boolean _active;

    public User() {

    }

    User(String username, String password, String name, boolean active) {
        _username = username;
        _password = password;
        _name = name;
        _active = active;
    }

    //region Getters & Setters
    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public boolean is_active() {
        return _active;
    }

    public void set_active(boolean _active) {
        this._active = _active;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
    //endregion
}
