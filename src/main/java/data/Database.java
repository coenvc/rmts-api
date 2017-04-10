package data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


public class Database {
    public static final SessionFactory SESSION = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static boolean save(Object object) {
        Session session = Database.SESSION.openSession();

        session.beginTransaction();

        boolean result = session.save(object) != null;

        session.getTransaction().commit();

        session.close();

        return result;
    }

    public static boolean update(Object object) {
        Session session = Database.SESSION.openSession();

        session.beginTransaction();

        session.saveOrUpdate(object);

        session.getTransaction().commit();

        session.close();

        return true;
    }

    public static boolean delete(Object object){
        Session session = Database.SESSION.openSession();

        session.beginTransaction();

        session.delete(object);

        session.getTransaction().commit();

        session.close();

        return true;
    }
}

