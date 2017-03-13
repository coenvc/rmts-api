package repository.user;

import data.Database;
import model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateUserRepository implements UserRepository {

    public void insert(User user) {
        Database.save(user);
    }

    public List getAll() {
        Session session = Database.SESSION.openSession();

        Query query = session.createQuery("FROM User ");

        List result = query.getResultList();

        session.close();

        return result;
    }

    public User find(int id) {
        Session session = Database.SESSION.openSession();

        User user = session.find(User.class, id);

        session.close();

        return user;
    }
}