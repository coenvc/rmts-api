package repository.action;


import data.CrudOperation;
import data.Database;
import data.HibernateCrudOperation;
import model.Action;
import model.Prospect;
import model.SortedActions;
import model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class HibernateActionRepository implements ActionRepository {

    private CrudOperation crud = new HibernateCrudOperation();

    public boolean insert(Action action) {
        return crud.create(action);
    }

    public boolean update(Action action) {
        return crud.update(action);
    }

    public boolean delete(Action action) {
        return crud.delete(action);
    }

    public SortedActions getAll() {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Action");

        List result = query.getResultList();

        SortedActions sortedActions = filterList(result);

        session.close();

        return sortedActions;
    }

    public SortedActions getAllByUser(User user) {
        return null;
    }

    public SortedActions getAllByProspect(Prospect prospect) {
        return null;
    }

    public Action find(int id) {
        Session session = Database.SESSION.openSession();

        Action action = session.find(Action.class, id);

        session.close();

        return action;
    }

    //region Helper methods
    private SortedActions filterList(List<Action> result) {
        List<Action> today = new ArrayList<Action>();
        List<Action> thisWeek = new ArrayList<Action>();
        List<Action> thisMonth = new ArrayList<Action>();
        List<Action> remainder = new ArrayList<Action>();

        DateTime date = new DateTime();
        int todayNumber = date.getDayOfYear();
        int weekNumber = date.weekOfWeekyear().get();
        int monthNumber = date.getMonthOfYear();

        for (Action action : result) {
            int currentDayNumber = action.getDate().getDayOfYear();
            int currentWeekNumber = action.getDate().weekOfWeekyear().get();
            int currentMonthNumber = action.getDate().getMonthOfYear();

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
    //endregion
}
