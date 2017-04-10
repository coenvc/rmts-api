package service.status;


import model.status.Status;
import repository.status.StatusRepository;


import java.util.List;

public class DefaultStatusService implements StatusService {

    private StatusRepository repository;

    public Boolean insert(Status status) {
        return repository.insert(status);
    }

    public Boolean update(Status status) {
        return repository.update(status);
    }

    public Boolean delete(Status status) {
        return repository.delete(status);
    }

    public List getAll() {
        return repository.getAll();
    }

    public Status find(int id) {
        return repository.find(id);
    }

    //region Getters & Setters

    public void setRepository(StatusRepository repository) {
        this.repository = repository;
    }

    //endregion
}
