package repository.actionType;

import model.action.ActionType;

import java.util.List;

public interface ActionTypeRepository {

    List getAll();
    ActionType find(int id);
}
