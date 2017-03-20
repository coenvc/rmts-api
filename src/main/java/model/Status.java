package model;

import javax.persistence.*;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _id;

    @Column
    private String content;

    public Status() {
    }

    //region Setters & Getters
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    //endregion
}
