package service.actionType;

import model.action.ActionType;
import repository.actionType.ActionTypeRepository;

import java.util.List;

public class DefaultActionTypeService implements ActionTypeService{

    private ActionTypeRepository repository;

    public List getAll() {
        return repository.getAll();
    }

    public ActionType find(int id) {
        return repository.find(id);
    }

    //region Getters & Setters

    public void setRepository(ActionTypeRepository repository) {
        this.repository = repository;
    }

    //endregion
}
