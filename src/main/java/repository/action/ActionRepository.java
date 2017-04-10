package repository.action;

import model.Action;
import model.User;

import java.util.List;

public interface ActionRepository {

    boolean insert(Action action);
    boolean update(Action action);
    boolean delete(Action action);
    List getAllByUser(User user);
    Action find(int id);

}
