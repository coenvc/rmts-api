package controller;

import data.crud.CrudService;
import model.action.Action;
import model.prospect.Prospect;
import model.action.SortedActions;
import model.user.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.action.ActionService;

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

    @RequestMapping(value = "/all/user", method = {RequestMethod.POST})
    public SortedActions getAllByUser(@RequestBody User user) {
        if (user == null) return null;

        return service.getAllByUser(user);
    }

    @RequestMapping(value = "/all/prospect", method = {RequestMethod.POST})
    public SortedActions getAllByUser(@RequestBody Prospect prospect) {
        if (prospect == null) return null;

        return service.getAllByProspect(prospect);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Action find(@PathVariable("id") Integer id) {
        if (id == null) return null;

        return service.find(id);
    }

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    public ResponseEntity<String> insert(@RequestBody Action action) {
        return crudService.insert(action);
    }

    @RequestMapping(value = "/update", method = {RequestMethod.PUT})
    public ResponseEntity<String> update(@RequestBody Action action) {
        return crudService.update(action);
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE})
    public ResponseEntity<String> delete(@RequestBody(required = false) Action action) {
        return crudService.delete(action);
    }
}
