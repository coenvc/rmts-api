package service.prospect;

import model.prospect.Prospect;
import repository.prospect.ProspectRepository;

import java.util.List;

public class DefaultProspectService implements ProspectService {

    private ProspectRepository repository;

    public boolean insert(Prospect prospect) {
        return repository.insert(prospect);
    }

    public boolean update(Prospect prospect) {
        return repository.update(prospect);
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
