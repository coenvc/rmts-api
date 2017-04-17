package service.action;


import model.Action;
import model.SortedActions;
import model.User;
import repository.action.ActionRepository;

import java.util.List;

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

    public SortedActions getAllByUser(User user) {
        return repository.getAllByUser(user);
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
