package service.status;


import model.status.Status;

import java.util.List;

public interface StatusService {

    List getAll();
    Status find(int id);
}
