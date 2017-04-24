package model.action;

import model.Crudable;

import javax.persistence.*;

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
