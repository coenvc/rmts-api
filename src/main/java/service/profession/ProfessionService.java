package service.profession;

import model.Crudable;
import model.profession.Profession;

import java.util.List;

public interface ProfessionService {

    List getAll();

    Profession find(int id);
}
