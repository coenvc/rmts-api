package repository;

import model.Test;

public interface TestRepository {

    void insert(Test test);

    Test find(int id);

}
