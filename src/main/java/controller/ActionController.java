package controller;

import data.crud.CrudService;
import model.action.Action;
import model.action.SortedActions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.action.ActionService;

import java.util.List;

@RestController()
@RequestMapping("/action")
@CrossOrigin("*")
public class ActionController {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private ActionService service = appContext.getBean("actionService", ActionService.class);
    private CrudService crudService = appContext.getBean("crudService", CrudService.class);

    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public SortedActions getAll() {

        return service.getAll();
    }

    @RequestMapping(value = "/all/user/{userId}", method = {RequestMethod.GET})
    public SortedActions getAllByUser(@PathVariable("userId") Integer userId) {
        if (userId == null) return null;

        return service.getAllByUserSorted(userId);
    }

    @RequestMapping(value = "/all/prospect/{prospectId}", method = {RequestMethod.GET})
    public SortedActions getAllByProspect(@PathVariable("prospectId") Integer prospectId) {
        if (prospectId == null) return null;

        return service.getAllByProspectSorted(prospectId);
    }

    @RequestMapping(value = "/all/unsorted/user/{userId}", method = {RequestMethod.GET})
    public List<Action> getAllByUserUnsorted(@PathVariable("userId") Integer userId) {
        if (userId == null) return null;

        return service.getAllByUserUnsorted(userId);
    }

    @RequestMapping(value = "/all/unsorted/prospect/{prospectId}", method = {RequestMethod.GET})
    public List<Action> getAllByProspectUnsorted(@PathVariable("prospectId") Integer prospectId) {
        if (prospectId == null) return null;

        return service.getAllByProspectUnsorted(prospectId);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Action find(@PathVariable("id") Integer id) {
        if (id == null) return null;

        return service.find(id);
    }

    @RequestMapping(value = "", method = {RequestMethod.POST})
    public ResponseEntity<String> insert(@RequestBody Action action) {
        return crudService.insert(action);
    }

    @RequestMapping(value = "", method = {RequestMethod.PUT})
    public ResponseEntity<String> update(@RequestBody Action action) {
        return crudService.update(action);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        return crudService.delete(service.find(id));
    }
}
