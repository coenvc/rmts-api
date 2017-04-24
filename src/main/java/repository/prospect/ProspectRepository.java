package repository.prospect;

import model.prospect.Prospect;

import java.util.List;

public interface ProspectRepository {

    List getAll();
    Prospect find(int id);

}
