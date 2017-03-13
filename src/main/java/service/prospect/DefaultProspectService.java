package service.prospect;

import model.Prospect;
import repository.prospect.ProspectRepository;

import java.util.List;

public class DefaultProspectService implements ProspectService {

    private ProspectRepository repository;

    public void insert(Prospect prospect) {
        repository.insert(prospect);
    }

    public List getAll() {
        return repository.getAll();
    }

    public Prospect find(int id) {
        return repository.find(id);
    }

    //region Getters & Setters

    public void setRepository(ProspectRepository repository) {
        this.repository = repository;
    }


    //endregion

}
