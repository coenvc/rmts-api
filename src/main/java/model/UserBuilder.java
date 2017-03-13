package model;

public class UserBuilder {

    private String _username;
    private String _password;
    private String _name;
    private boolean _active = false;

    public UserBuilder username(String username) {
        if (username == null) {
            throw new NullPointerException("Username is missing");
        }
        this._username = username;
        return this;
    }

    public UserBuilder password(String password) {
        if (password == null) {
            throw new NullPointerException("Password is missing");
        }
        this._password = password;
        return this;
    }

    public UserBuilder name(String name) {
        if (name == null) {
            throw new NullPointerException("Name is missing");
        }
        this._name = name;
        return this;
    }

    public UserBuilder active(boolean active) {
        this._active = active;
        return this;
    }

    public User build() {
        return new User(_username, _password, _name, _active);
    }
}
