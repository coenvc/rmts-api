package service;

import model.Test;
import repository.TestRepository;

public class TestServiceImpl implements TestService {

    private TestRepository repository;

    public void insert(Test test) {
        repository.insert(test);
    }

    public Test find(int id) {
        return repository.find(id);
    }

    //region Getters & Setters

    public void setRepository(TestRepository repository) {
        this.repository = repository;
    }

    //endregion
}
