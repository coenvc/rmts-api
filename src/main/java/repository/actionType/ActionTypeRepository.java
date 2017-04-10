package repository.actionType;

import model.ActionType;

import java.util.List;

public interface ActionTypeRepository {

    boolean insert(ActionType actionType);
    boolean update(ActionType actionType);
    boolean delete(ActionType actionType);
    List getAll();
    ActionType find(int id);
}
