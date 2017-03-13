package service.prospect;

import model.Prospect;

import java.util.List;

public interface ProspectService {

    void insert(Prospect prospect);

    List getAll();

    Prospect find(int id);
}
