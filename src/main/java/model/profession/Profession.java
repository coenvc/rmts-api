package model.profession;

import model.Crudable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profession implements Crudable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String name;

    public Profession(String name) {
        this.name = name;
    }

    public Profession() {

    }

    public boolean isIncomplete() {
        return name == null;
    }

    public List<String> getIncompleteProperties() {
        List<String> list = new ArrayList<String>();

        if (name == null) list.add("name");

        return list;
    }

    //region Getters & Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    //endregion
}
