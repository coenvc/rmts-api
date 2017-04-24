package service.actionType;

import model.action.ActionType;

import java.util.List;

public interface ActionTypeService {

    boolean insert(ActionType actionType);
    boolean update(ActionType actionType);
    boolean delete(ActionType actionType);
    List getAll();
    ActionType find(int id);
}
