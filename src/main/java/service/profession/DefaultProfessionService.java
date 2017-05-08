package service.profession;

import model.profession.Profession;
import repository.profession.ProfessionRepository;

import java.util.List;

public class DefaultProfessionService implements ProfessionService {

    private ProfessionRepository repository;

    public List getAll() {
        return repository.getAll();
    }

    public Profession find(int id) {
        return repository.find(id);
    }

    //region Getters & Setters

    public void setRepository(ProfessionRepository repository) {
        this.repository = repository;
    }

    //endregion
}
