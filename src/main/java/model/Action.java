package model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(targetEntity = ActionType.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ActionType actionType;

    @Column
    private Date date;

    @Column
    private String description;

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @Column
    private boolean isCompleted;

    public Action(){

    }

    public Action(ActionType actionType, Date date, String description, User user, boolean isCompleted) {
        this.actionType = actionType;
        this.date = date;
        this.description = description;
        this.user = user;
        this.isCompleted = isCompleted;
    }

    //region Setters & Getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    //endregion
}
