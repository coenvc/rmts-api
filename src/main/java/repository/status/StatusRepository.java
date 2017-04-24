package repository.status;



import model.status.Status;

import java.util.List;

public interface StatusRepository {

    List getAll();
    Status find(int id);




}
