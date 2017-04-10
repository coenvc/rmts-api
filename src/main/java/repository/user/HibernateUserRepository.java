package repository.user;

import data.CrudOperation;
import data.Database;
import data.HibernateCrudOperation;
import model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.List;

public class HibernateUserRepository implements UserRepository {

    private CrudOperation crud = new HibernateCrudOperation();

    public User login(String username, String password) {

        Session session = Database.SESSION.openSession();

        User user = (User) session.createQuery("FROM User WHERE username = :username AND password = :password")
                .setParameter("username",username)
                .setParameter("password", password)
                .uniqueResult();

        return user;
    }

    public boolean insert(User user) {
        return crud.create(user);
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
