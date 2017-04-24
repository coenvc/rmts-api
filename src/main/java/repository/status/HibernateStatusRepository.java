package repository.status;


import data.Database;
import model.status.Status;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateStatusRepository implements StatusRepository{


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
