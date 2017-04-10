package data;

public interface CrudOperation {
    boolean create(Object object);

    boolean update(Object object);

    boolean delete(Object object);
}
