package repository.profession;

import data.Database;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateProfessionRepository implements ProfessionRepository {

    public List getAll() {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM Profession ");

        List result = query.getResultList();

        session.close();

        return result;
    }
}
