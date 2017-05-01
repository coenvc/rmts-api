package repository.action;


import data.Database;
import model.action.Action;
import model.action.ActionComparator;
import model.action.SortedActions;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class HibernateActionRepository implements ActionRepository {

    public SortedActions getAll() {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Action");

        List result = query.getResultList();

        SortedActions sortedActions = SortedActions.filterList(result);

        session.close();

        return sortedActions;
    }

    public SortedActions getAllByUserSorted(int userId) {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Action WHERE user.id = :user").setParameter("user", userId);

        List result = query.getResultList();

        SortedActions sortedActions = SortedActions.filterList(result);

        session.close();

        return sortedActions;
    }

    public SortedActions getAllByProspectSorted(int prospectId) {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Action WHERE prospect.id = :prospect").setParameter("prospect", prospectId);

        List result = query.getResultList();

        SortedActions sortedActions = SortedActions.filterList(result);

        session.close();

        return sortedActions;
    }

    public List<Action> getAllByUserUnsorted(int userId) {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Action WHERE user.id = :userId").setParameter("userId", userId);

        List<Action> result = query.getResultList();

        Collections.sort(result, new ActionComparator());

        session.close();

        return result;
    }

    public List<Action> getAllByProspectUnsorted(int prospectId) {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Action WHERE prospect.id = :prospectId").setParameter("prospectId", prospectId);

        List<Action> result = query.getResultList();

        Collections.sort(result, new ActionComparator());

        session.close();

        return result;
    }

    public Action find(int id) {
        Session session = Database.SESSION.openSession();

        Action action = session.find(Action.class, id);

        session.close();

        return action;
    }

    //region Helper methods

    //endregion
}
