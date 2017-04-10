package repository.status;


import model.status.Status;

import java.util.ArrayList;
import java.util.List;

public class TestStatusRepository implements StatusRepository {

    private static List<Status> statusList(){
        ArrayList<Status> list = new ArrayList<Status>();
        for (int i = 0; i < 10; i++){
           Status status = new Status("Test" + i);
           status.setId(i);
           list.add(status);
        }

        return list;
    }


    public boolean insert(Status status) {
        return status != null;
    }

    public boolean update(Status status) {
        return status != null;
    }

    public boolean delete(Status status) {
        return status != null;
    }

    public List getAll() {

        return statusList();
    }

    public Status find(final int id) {
        for (int i = 0; i < statusList().size(); i++){
            if(statusList().get(i).getId() == id)
                return statusList().get(i);
        }
        return null;
    }
}
