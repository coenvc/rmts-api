package service.user;

import model.User;
import repository.user.UserRepository;

import java.util.List;

public class DefaultUserService implements UserService {

    private UserRepository repository;

    public void insert(User user) {
        repository.insert(user);
    }

    public List getAll() {
        return repository.getAll();
    }

    public User find(int id) {
        return repository.find(id);
    }

    //region Getters & Setters
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
    //endregion

}
