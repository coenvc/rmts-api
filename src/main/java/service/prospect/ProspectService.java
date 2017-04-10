package service.prospect;

import model.Prospect;

import java.util.List;

public interface ProspectService {

    boolean insert(Prospect prospect);

    boolean update(Prospect prospect);

    List getAll();

    Prospect find(int id);
}
