package repository.actionType;

import data.Database;
import model.action.ActionType;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateActionTypeRepository implements ActionTypeRepository {

    public List getAll() {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM ActionType ");

        List result = query.getResultList();

        session.close();

        return result;
    }

    public ActionType find(int id) {
        Session session = Database.SESSION.openSession();

        ActionType actionType = session.find(ActionType.class, id);

        session.close();

        return actionType;
    }
}
