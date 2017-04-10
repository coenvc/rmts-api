package repository.prospect;

import model.Prospect;

import java.util.List;

public interface ProspectRepository {

    boolean insert(Prospect prospect);
    boolean update(Prospect prospect);
    List getAll();
    Prospect find(int id);

}
