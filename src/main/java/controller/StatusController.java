package controller;

import data.crud.CrudService;
import model.status.Status;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.status.StatusService;

import java.util.List;

@RestController()
@RequestMapping("/status")
@CrossOrigin("*")
public class StatusController {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private StatusService service = appContext.getBean("statusService", StatusService.class);
    private CrudService crudService = appContext.getBean("crudService", CrudService.class);

    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public List getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Status find(@PathVariable("id") Integer id) {
        if (id == null) return null;

        return service.find(id);
    }

    @RequestMapping(value = "", method = {RequestMethod.POST})
    public ResponseEntity<String> insert(@RequestBody Status status) {
        return crudService.insert(status);
    }

    @RequestMapping(value = "", method = {RequestMethod.PUT})
    public ResponseEntity<String> update(@RequestBody Status status) {
        return crudService.update(status);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        return crudService.delete(service.find(id));
    }

}
