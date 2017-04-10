package data;

public interface CrudOperation {
    boolean save(Object object);

    boolean update(Object object);

    boolean delete(Object object);
}
