package controller;

import data.CrudService;
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

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    public ResponseEntity<String> insert(@RequestBody ActionType actionType) {
        return crudService.insert(actionType);
    }

    @RequestMapping(value = "/update", method = {RequestMethod.PUT})
    public ResponseEntity<String> update(@RequestBody ActionType actionType) {
        return crudService.update(actionType);
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE})
    public ResponseEntity<String> delete(@RequestBody(required = false) ActionType actionType) {
        return crudService.delete(actionType);
    }
}
