package service.user;

import model.User;

import java.util.List;

public interface UserService {
    User login(String username, String password);
    void insert(User user);
    List getAll();
    User find(int id);

}
