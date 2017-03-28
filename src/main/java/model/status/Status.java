package model.status;

import javax.persistence.*;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true) //TODO: Dit doet niet wat wij denken dat het doet. De duplicate data moet anders opgelost worden.
    private String content;

    public Status() {

    }

    public Status(String content) {
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
