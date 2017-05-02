package model.action;

import model.Crudable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ActionType implements Crudable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column()
    private String content;

    public ActionType(){

    }

    public boolean isIncomplete() {
        return content == null;
    }

    public List<String> getIncompleteProperties() {
        List<String> list = new ArrayList<String>();

        if (content == null) list.add("content");

        return list;
    }

    public ActionType(String content){
        this.content = content;
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
