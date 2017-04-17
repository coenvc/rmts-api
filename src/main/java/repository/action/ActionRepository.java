package repository.action;

import model.Action;
import model.Prospect;
import model.SortedActions;
import model.User;


public interface ActionRepository {

    boolean insert(Action action);
    boolean update(Action action);
    boolean delete(Action action);

    SortedActions getAll();
    SortedActions getAllByUser(User user);
    SortedActions getAllByProspect(Prospect prospect);

    Action find(int id);
}