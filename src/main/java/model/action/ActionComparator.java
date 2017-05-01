package model.action;

import java.util.Comparator;

public class ActionComparator implements Comparator<Action> {

    public int compare(Action o1, Action o2) {
        return o1.getDate().compareTo(o2.getDate());
    }

}