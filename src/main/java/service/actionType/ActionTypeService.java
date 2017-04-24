package service.actionType;

import model.action.ActionType;

import java.util.List;

public interface ActionTypeService {

    List getAll();
    ActionType find(int id);
}
