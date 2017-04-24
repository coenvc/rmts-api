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

        SortedActions sortedActions = SortedActions.filterList(result);

        session.close();

        return sortedActions;
    }

    @SuppressWarnings("JpaQlInspection")
    public SortedActions getAllByUser(User user) {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Action WHERE user_id = :user").setParameter("user", user.getId());

        List result = query.getResultList();

        SortedActions sortedActions = SortedActions.filterList(result);

        session.close();

        return sortedActions;
    }

    @SuppressWarnings("JpaQlInspection")
    public SortedActions getAllByProspect(Prospect prospect) {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Action WHERE prospect_id = :prospect").setParameter("prospect", prospect.getid());

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
