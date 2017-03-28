package model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private boolean active;

    public User() {

    }

    User(String username, String password, String name, boolean active) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.active = active;
    }

    //region Getters & Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String _username) {
        this.username = _username;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean _active) {
        this.active = _active;
    }

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //endregion
}
