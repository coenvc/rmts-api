package repository.action;


import data.Database;
import model.action.Action;
import model.prospect.Prospect;
import model.action.SortedActions;
import model.user.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

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

    @SuppressWarnings("JpaQlInspection")
    public SortedActions getAllByUser(int userId) {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Action WHERE user_id = :user").setParameter("user", userId);

        List result = query.getResultList();

        SortedActions sortedActions = SortedActions.filterList(result);

        session.close();

        return sortedActions;
    }

    @SuppressWarnings("JpaQlInspection")
    public SortedActions getAllByProspect(int prospectId) {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Action WHERE prospect_id = :prospect").setParameter("prospect", prospectId);

        List result = query.getResultList();

        SortedActions sortedActions = SortedActions.filterList(result);

        session.close();

        return sortedActions;
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
