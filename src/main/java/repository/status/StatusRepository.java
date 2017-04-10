package repository.status;



import model.status.Status;

import java.util.List;

public interface StatusRepository {

    boolean insert(Status status);
    boolean update(Status status);
    boolean delete(Status status);
    List getAll();
    Status find(int id);




}
