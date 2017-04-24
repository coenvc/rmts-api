package repository.prospect;

import data.Database;
import model.prospect.Prospect;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateProspectRepository implements ProspectRepository {


    public List getAll() {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Prospect");

        List result = query.getResultList();

        session.close();

        return result;
    }

    public Prospect find(int id) {
        Session session = Database.SESSION.openSession();

        Prospect prospect = session.find(Prospect.class, id);

        session.close();

        return prospect;
    }
}
