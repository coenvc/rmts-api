package model.action;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class ActionComparatorTest {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Test
    public void GivenTwoDatesInOrder_SortedFromNearestToFurthest() throws ParseException {
        List<Action> actions = new ArrayList<Action>();

        Action a1 = new Action();
        a1.setDate(sdf.parse("01/05/2017"));

        Action a2 = new Action();
        a2.setDate(sdf.parse("02/05/2017"));

        actions.add(a1);
        actions.add(a2);

        Collections.sort(actions, new ActionComparator());

        checkDates(actions);
    }

    @Test
    public void GivenTwoDatesOutOfOrder_SortedFromNearestToFurthest() throws ParseException {
        List<Action> actions = new ArrayList<Action>();

        Action a2 = new Action();
        a2.setDate(sdf.parse("02/05/2017"));

        Action a1 = new Action();
        a1.setDate(sdf.parse("01/05/2017"));

        actions.add(a2);
        actions.add(a1);

        Collections.sort(actions, new ActionComparator());

        checkDates(actions);
    }

    @Test
    public void GivenManyDatesOutOfOrder_SortedFromNearestToFurthest() throws ParseException {
        List<Action> actions = new ArrayList<Action>();

        for (int i = 0; i < 10; i++) {
            Action a = new Action();
            a.setDate(sdf.parse("0" + (9 - i) + "/05/2017"));
            actions.add(a);
        }

        Collections.sort(actions, new ActionComparator());

        checkDates(actions);
    }

    private void checkDates(List<Action> actions) {
        Action previous = null;
        for (Action a : actions) {
            if (previous != null) {
                assertTrue(previous.getDate().before(a.getDate()));
            }
            previous = a;
        }
    }
}