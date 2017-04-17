package model;

import java.util.List;

public class SortedActions {

    private List<Action> today;
    private List<Action> thisWeek;
    private List<Action> thisMonth;
    private List<Action> remainder;

    public SortedActions(List<Action> today, List<Action> thisWeek, List<Action> thisMonth, List<Action> remainder) {
        this.today = today;
        this.thisWeek = thisWeek;
        this.thisMonth = thisMonth;
        this.remainder = remainder;
    }

    //region Getters & Setters

    public List<Action> getToday() {
        return today;
    }

    public List<Action> getThisWeek() {
        return thisWeek;
    }

    public List<Action> getThisMonth() {
        return thisMonth;
    }

    public List<Action> getRemainder() {
        return remainder;
    }

    //endregion
}
