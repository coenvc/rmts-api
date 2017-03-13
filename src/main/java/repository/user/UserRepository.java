package repository.user;

import model.User;

import java.util.List;

public interface UserRepository {

    void insert(User user);

    List getAll();

    User find(int id);

}
