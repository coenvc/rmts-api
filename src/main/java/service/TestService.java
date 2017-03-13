package service;

import model.Test;

public interface TestService {

    void insert(Test test);
    Test find(int id);

}
