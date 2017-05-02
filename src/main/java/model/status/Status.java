package model.status;

import model.Crudable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Status implements Crudable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String content;

    public Status() {

    }

    public Status(String content) {
        this.content = content;
    }

    public boolean isIncomplete() {
        return content == null;
    }

    public List<String> getIncompleteProperties() {
        List<String> list = new ArrayList<String>();

        if (content == null) list.add("content");

        return list;
    }

    //region Setters & Getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    //endregion
}
