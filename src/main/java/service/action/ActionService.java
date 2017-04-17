package service.action;


import model.Action;
import model.SortedActions;
import model.User;

import java.util.List;

public interface ActionService {

    boolean insert(Action action);
    boolean update(Action action);
    boolean delete(Action action);
    SortedActions getAllByUser(User user);
    Action find(int id);

}
