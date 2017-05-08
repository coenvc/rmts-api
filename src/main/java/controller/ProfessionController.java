package controller;

import data.crud.CrudService;
import model.profession.Profession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.profession.ProfessionService;

import java.util.List;

@RestController()
@RequestMapping("/profession")
@CrossOrigin("*")
public class ProfessionController {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private ProfessionService service = appContext.getBean("professionService", ProfessionService.class);
    private CrudService crudService = appContext.getBean("crudService", CrudService.class);

    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public List getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "", method = {RequestMethod.POST})
    public ResponseEntity<String> insert(@RequestBody Profession profession) {
        return crudService.insert(profession);
    }

    @RequestMapping(value = "", method = {RequestMethod.PUT})
    public ResponseEntity<String> update(@RequestBody Profession profession) {
        return crudService.update(profession);
    }

    @RequestMapping(value = "", method = {RequestMethod.DELETE})
    public ResponseEntity<String> delete(@RequestBody Profession profession) {
        return crudService.delete(profession);
    }
}
