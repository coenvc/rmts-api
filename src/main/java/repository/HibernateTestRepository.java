package repository;

import data.Database;
import model.Test;
import org.hibernate.Session;


public class HibernateTestRepository implements TestRepository {

    public void insert(Test test) {
        Session session = Database.SESSION.openSession();

        session.beginTransaction();

        session.save(test);

        session.getTransaction().commit();

        session.close();
    }

    public Test find(int id) {
        Session session = Database.SESSION.openSession();

        session.beginTransaction();

        Test test = session.find(Test.class, id);

        session.close();

        return test;
    }

}
