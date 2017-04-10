package data;


import org.hibernate.Session;

public class HibernateCrudOperation implements CrudOperation {

    public boolean create(Object object) {
        Session session = Database.SESSION.openSession();

        session.beginTransaction();

        boolean result = session.save(object) != null;

        session.getTransaction().commit();

        session.close();

        return result;
    }

    public boolean update(Object object) {
        Session session = Database.SESSION.openSession();

        session.beginTransaction();

        session.saveOrUpdate(object);

        session.getTransaction().commit();

        session.close();

        return true;
    }

    public boolean delete(Object object){
        Session session = Database.SESSION.openSession();

        session.beginTransaction();

        session.delete(object);

        session.getTransaction().commit();

        session.close();

        return true;
    }

}
