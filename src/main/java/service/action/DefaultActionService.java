package service.action;


import model.action.Action;
import model.action.SortedActions;
import repository.action.ActionRepository;

import java.util.List;

public class DefaultActionService implements ActionService {

    private ActionRepository repository;

    public SortedActions getAll() {
        return repository.getAll();
    }

    public SortedActions getAllByUserSorted(int userId) {
        return repository.getAllByUserSorted(userId);
    }

    public SortedActions getAllByProspectSorted(int prospectId) {
        return repository.getAllByProspectSorted(prospectId);
    }

    public List<Action> getAllByUserUnsorted(int userId) {
        return repository.getAllByUserUnsorted(userId);
    }

    public List<Action> getAllByProspectUnsorted(int prospectId) {
        return repository.getAllByProspectUnsorted(prospectId);
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
