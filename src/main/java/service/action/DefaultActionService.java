package service.action;


import model.action.Action;
import model.prospect.Prospect;
import model.action.SortedActions;
import model.user.User;
import repository.action.ActionRepository;

public class DefaultActionService implements ActionService {

    private ActionRepository repository;

    public SortedActions getAll() {
        return repository.getAll();
    }

    public SortedActions getAllByUser(int userId) {
        return repository.getAllByUser(userId);
    }

    public SortedActions getAllByProspect(int prospectId) {
        return repository.getAllByProspect(prospectId);
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
