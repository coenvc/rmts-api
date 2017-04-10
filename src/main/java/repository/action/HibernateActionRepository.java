package repository.action;


import data.CrudOperation;
import data.Database;
import data.HibernateCrudOperation;
import model.Action;
import model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

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

    public List getAllByUser(User user) {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Action ");

        List result = query.getResultList();

        session.close();

        return result;
    }

    public Action find(int id) {
        Session session = Database.SESSION.openSession();

        Action action = session.find(Action.class, id);

        session.close();

        return action;
    }
}
