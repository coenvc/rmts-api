package service.prospect;

import model.prospect.Prospect;

import java.util.List;

public interface ProspectService {

    List getAll();

    Prospect find(int id);
}
