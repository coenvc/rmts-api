package model.action;


import model.Crudable;
import model.prospect.Prospect;
import model.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Action implements Crudable {

    // Complex types
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(targetEntity = ActionType.class, fetch = FetchType.EAGER)
    private ActionType actionType;

    @Temporal(value = TemporalType.DATE)
    private Date date;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User user;

    @OneToOne(targetEntity = Prospect.class, fetch = FetchType.EAGER)
    @JoinColumn
    private Prospect prospect;

    // Basic types
    private String description;
    private boolean isCompleted;
    private String location;

    public Action(){

    }

    public Action(ActionType actionType, Date date, String description, User user,Prospect prospect, boolean isCompleted) {
        this.actionType = actionType;
        this.date = date;
        this.description = description;
        this.user = user;
        this.prospect = prospect;
        this.isCompleted = isCompleted;
    }


    public boolean isIncomplete() {
        return actionType == null ||
                date == null ||
                user == null ||
                prospect == null;
    }

    public List<String> getIncompleteProperties() {
        List<String> list = new ArrayList<String>();

        if (actionType != null && actionType.isIncomplete() ) list.addAll(actionType.getIncompleteProperties());
        if (actionType == null) list.add("actionType");
        if (date == null) list.add("date");
        if (user != null && user.isIncomplete()) list.addAll(user.getIncompleteProperties());
        if (user == null) list.add("user");
        if (prospect != null && prospect.isIncomplete()) list.addAll(prospect.getIncompleteProperties());
        if (prospect == null) list.add("prospect");

        return list;
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

    public Prospect getProspect() {
        return prospect;
    }

    public void setProspect(Prospect prospect) {
        this.prospect = prospect;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    //endregion
}
