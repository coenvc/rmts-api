package service.actionType;

import model.ActionType;
import repository.actionType.ActionTypeRepository;

import java.util.List;

public class DefaultActionTypeService implements ActionTypeService{

    private ActionTypeRepository repository;

    public boolean insert(ActionType actionType) {
        return repository.insert(actionType);
    }

    public boolean update(ActionType actionType) {
        return repository.update(actionType);
    }

    public boolean delete(ActionType actionType) {
        return repository.delete(actionType);
    }

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
