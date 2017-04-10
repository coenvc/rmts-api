package repository.status;


import data.CrudOperation;
import data.Database;
import data.HibernateCrudOperation;
import model.status.Status;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateStatusRepository implements StatusRepository{
    
    private CrudOperation crud = new HibernateCrudOperation();

    public boolean insert(Status status) {
        return crud.save(status);
    }

    public boolean update(Status status) {
        return crud.update(status);
    }

    public boolean delete(Status status) {
        return crud.delete(status);
    }

    public List getAll() {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Status ");

        List result = query.getResultList();

        session.close();

        return result;
    }

    public Status find(int id) {
        Session session = Database.SESSION.openSession();

        Status status = session.find(Status.class, id);

        session.close();

        return status;
    }
}
