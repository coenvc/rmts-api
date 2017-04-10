package repository.prospect;

import data.CrudOperation;
import data.Database;
import data.HibernateCrudOperation;
import model.Prospect;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateProspectRepository implements ProspectRepository {

    private CrudOperation crud = new HibernateCrudOperation();

    public boolean insert(Prospect prospect) {
        return crud.create(prospect);
    }

    public boolean update(Prospect prospect) {
        return crud.update(prospect);
    }

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
