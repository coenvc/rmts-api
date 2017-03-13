package service.user;

import model.User;

import java.util.List;

public interface UserService {

    void insert(User user);
    List getAll();
    User find(int id);

}
