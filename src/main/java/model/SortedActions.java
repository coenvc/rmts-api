package model;

import org.joda.time.DateTime;

import java.util.ArrayList;
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

    public static SortedActions filterList(List<Action> result) {
        List<Action> today = new ArrayList<Action>();
        List<Action> thisWeek = new ArrayList<Action>();
        List<Action> thisMonth = new ArrayList<Action>();
        List<Action> remainder = new ArrayList<Action>();

        DateTime date = new DateTime();
        int todayNumber = date.getDayOfYear();
        int weekNumber = date.weekOfWeekyear().get();
        int monthNumber = date.getMonthOfYear();

        for (Action action : result) {

            DateTime dt = new DateTime(action.getDate());

            int currentDayNumber = dt.getDayOfYear();
            int currentWeekNumber = dt.weekOfWeekyear().get();
            int currentMonthNumber = dt.getMonthOfYear();

            if (currentDayNumber == todayNumber) {
                today.add(action);
            }
            else if (currentWeekNumber == weekNumber) {
                thisWeek.add(action);
            }
            else if (currentMonthNumber == monthNumber) {
                thisMonth.add(action);
            }
            else {
                remainder.add(action);
            }
        }

        return new SortedActions(today, thisWeek, thisMonth, remainder);
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
