package model;

public class UserBuilder {

    private String username = "";
    private String password = "";
    private String name = "";
    private boolean active = false;

    public UserBuilder username(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder active(boolean active) {
        this.active = active;
        return this;
    }

    public User build() {
        checkProperties();
        return new User(username, password, name, active);
    }

    private void checkProperties() {
        if (username.equals("")) throw new IllegalArgumentException("No username provided.");
        if (name.equals("")) throw new IllegalArgumentException("No name provided.");
        if (password.equals("")) throw new IllegalArgumentException("No password provided.");
    }
}
