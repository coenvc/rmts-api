package repository.actionType;

import data.CrudOperation;
import data.Database;
import data.HibernateCrudOperation;
import model.action.ActionType;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateActionTypeRepository implements ActionTypeRepository {

    private CrudOperation crud = new HibernateCrudOperation();

    public boolean insert(ActionType actionType) {
        return crud.create(actionType);
    }

    public boolean update(ActionType actionType) {
        return crud.update(actionType);
    }

    public boolean delete(ActionType actionType) {
        return crud.delete(actionType);
    }

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
