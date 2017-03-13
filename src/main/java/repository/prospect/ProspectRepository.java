package repository.prospect;

import model.Prospect;

import java.util.List;

public interface ProspectRepository {

    void insert(Prospect prospect);
    List getAll();
    Prospect find(int id);

}
