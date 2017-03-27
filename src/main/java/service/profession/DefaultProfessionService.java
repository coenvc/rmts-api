package service.profession;

import repository.profession.ProfessionRepository;

import java.util.List;

public class DefaultProfessionService implements ProfessionService {

    private ProfessionRepository repository;

    public List getAll() {
        return repository.getAll();
    }

    //region Getters & Setters

    public void setRepository(ProfessionRepository repository) {
        this.repository = repository;
    }

    //endregion
}
