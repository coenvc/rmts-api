package model.user;

import model.Crudable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User implements Crudable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String username;

    private String password;
    private String name;
    private boolean isActive;

    public User() {

    }

    User(String username, String password, String name, boolean active) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.isActive = active;
    }

    public boolean isIncomplete() {
        return username == null ||
                password == null ||
                name == null;
    }

    public List<String> getIncompleteProperties() {
        List<String> list = new ArrayList<String>();

        if (username == null) list.add("username");
        if (password == null) list.add("password");
        if (name == null) list.add("name");

        return list;
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
        return isActive;
    }

    public void setActive(boolean _active) {
        this.isActive = _active;
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
