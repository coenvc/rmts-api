package repository.action;

import model.action.Action;
import model.prospect.Prospect;
import model.action.SortedActions;
import model.user.User;


public interface ActionRepository {
    SortedActions getAll();
    SortedActions getAllByUser(int userId);
    SortedActions getAllByProspect(int prospectId);

    Action find(int id);
}