package model;

public class UserBuilder {

    private String username;
    private String password;
    private String name;
    private boolean active = false;

    public UserBuilder username(String username) {
        if (username == null) {
            throw new NullPointerException("Username is missing");
        }
        this.username = username;
        return this;
    }

    public UserBuilder password(String password) {
        if (password == null) {
            throw new NullPointerException("Password is missing");
        }
        this.password = password;
        return this;
    }

    public UserBuilder name(String name) {
        if (name == null) {
            throw new NullPointerException("Name is missing");
        }
        this.name = name;
        return this;
    }

    public UserBuilder active(boolean active) {
        this.active = active;
        return this;
    }

    public User build() {
        if (checkProperties()) {
            return new User(username, password, name, active);
        }
        return null;
    }

    private boolean checkProperties() {
        if (username.equals("") || username == null) {
            System.out.println("The UserBuilder did not receive a valid Username.");
            return false;
        }


        if (name.equals("") || password == null) {
            System.out.println("The UserBuilder did not receive a valid Name.");
            return false;
        }


        if (password.equals("") || password == null) {
            System.out.println("The UserBuilder did not receive a valid Password.");
            return false;
        }

        return true;
    }
}
