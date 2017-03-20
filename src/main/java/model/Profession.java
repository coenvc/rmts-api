package model;

import javax.persistence.*;

@Entity
public class Profession {

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
