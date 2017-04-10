package service.status;


import model.status.Status;

import java.util.List;

public interface StatusService {

    Boolean insert(Status status);
    Boolean update(Status status);
    Boolean delete(Status status);
    List getAll();
    Status find(int id);
}
