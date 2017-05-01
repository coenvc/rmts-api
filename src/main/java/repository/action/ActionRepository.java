package repository.action;

import model.action.Action;
import model.prospect.Prospect;
import model.action.SortedActions;
import model.user.User;

import java.util.List;


public interface ActionRepository {
    SortedActions getAll();

    SortedActions getAllByUserSorted(int userId);
    SortedActions getAllByProspectSorted(int prospectId);

    List<Action> getAllByUserUnsorted(int userId);
    List<Action> getAllByProspectUnsorted(int prospectId);

    Action find(int id);
}