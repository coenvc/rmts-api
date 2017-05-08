package controller;

import data.crud.CrudService;
import model.action.ActionType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.actionType.ActionTypeService;

import java.util.List;

@RestController()
@RequestMapping("/actionType")
@CrossOrigin("*")
public class ActionTypeController {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private ActionTypeService service = appContext.getBean("actionTypeService", ActionTypeService.class);
    private CrudService crudService = appContext.getBean("crudService", CrudService.class);

    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public List getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public ActionType find(@PathVariable("id") Integer id) {
        if (id == null) return null;

        return service.find(id);
    }

    @RequestMapping(value = "", method = {RequestMethod.POST})
    public ResponseEntity<String> insert(@RequestBody ActionType actionType) {
        return crudService.insert(actionType);
    }

    @RequestMapping(value = "", method = {RequestMethod.PUT})
    public ResponseEntity<String> update(@RequestBody ActionType actionType) {
        return crudService.update(actionType);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        return crudService.delete(service.find(id));
    }
}
