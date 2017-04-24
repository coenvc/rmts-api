package service.action;


import model.action.Action;
import model.prospect.Prospect;
import model.action.SortedActions;
import model.user.User;
import repository.action.ActionRepository;

public class DefaultActionService implements ActionService {

    private ActionRepository repository;

    public boolean insert(Action action) {
        return repository.insert(action);
    }

    public boolean update(Action action) {
        return repository.update(action);
    }

    public boolean delete(Action action) {
        return repository.delete(action);
    }

    public SortedActions getAll() {
        return repository.getAll();
    }

    public SortedActions getAllByUser(User user) {
        return repository.getAllByUser(user);
    }

    public SortedActions getAllByProspect(Prospect prospect) {
        return repository.getAllByProspect(prospect);
    }

    public Action find(int id) {
        return repository.find(id);
    }

    //region Getters & Setters

    public void setRepository(ActionRepository repository) {
        this.repository = repository;
    }

    //endregion

}
