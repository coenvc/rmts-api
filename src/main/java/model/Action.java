package model;


import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import javax.persistence.*;

@Entity
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(targetEntity = ActionType.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ActionType actionType;

    @Column
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime date;

    @Column
    private String description;

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;


    @OneToOne(targetEntity = Prospect.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Prospect prospect;

    @Column
    private boolean isCompleted;

    public Action(){

    }

    public Action(ActionType actionType, DateTime date, String description, User user,Prospect prospect, boolean isCompleted) {
        this.actionType = actionType;
        this.date = date;
        this.description = description;
        this.user = user;
        this.prospect = prospect;
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

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
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

    //endregion
}
