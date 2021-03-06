package model.action;

import model.prospect.Prospect;
import model.user.User;

import java.util.Date;

public class ActionBuilder {

    private int id;
    private ActionType actionType;

    private Date date;
    private String description;
    private User user;
    private Prospect prospect;
    private boolean isCompleted = false;

    public ActionBuilder id(int id){
        this.id = id;
        return this;
    }

    public ActionBuilder actionType(ActionType actionType){
        this.actionType = actionType;
        return this;
    }

    public ActionBuilder date(Date date){
        this.date = date;
        return this;
    }

    public ActionBuilder description(String description){
        this.description = description;
        return this;
    }

    public ActionBuilder user(User user){
        this.user = user;
        return this;
    }

    public ActionBuilder prospect(Prospect prospect){
        this.prospect = prospect;
        return this;
    }

    public ActionBuilder isComplete(boolean isCompleted){
        this.isCompleted = isCompleted;
        return this;
    }

    public Action build(){
        checkProperties();
        return new Action(actionType, date, description, user, prospect, isCompleted);
    }

    //region Helper methods
    private void checkProperties() {
        if (actionType == null) throw new IllegalArgumentException("No actionType specified.");
        if (date == null) throw new IllegalArgumentException("No date specified.");
        if (description == null) throw new IllegalArgumentException("No description specified.");
        if (user == null) throw new IllegalArgumentException("No user specified.");
        if (prospect == null) throw new IllegalArgumentException("No prospect specified.");
    }
    //endregion

}
