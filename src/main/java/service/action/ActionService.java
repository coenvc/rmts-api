package service.action;


import model.action.Action;
import model.prospect.Prospect;
import model.action.SortedActions;
import model.user.User;

public interface ActionService {
    SortedActions getAll();
    SortedActions getAllByUser(User user);
    SortedActions getAllByProspect(Prospect prospect);

    Action find(int id);

}
