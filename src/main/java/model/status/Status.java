package model.status;

import model.Crudable;

import javax.persistence.*;

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
