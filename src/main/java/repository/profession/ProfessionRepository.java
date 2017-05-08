package repository.profession;

import model.profession.Profession;

import java.util.List;

public interface ProfessionRepository {

    List getAll();

    Profession find(int id);
}
