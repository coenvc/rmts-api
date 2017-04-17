package controller;

import model.Action;
import model.SortedActions;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import service.action.ActionService;

import java.util.List;

@RestController()
@RequestMapping("/action")
@CrossOrigin("*")
public class ActionController {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private ActionService service = appContext.getBean("actionService", ActionService.class);

    @RequestMapping(value = "/all", method = {RequestMethod.POST})
    public SortedActions getAll(@RequestBody User user) {

        return service.getAllByUser(user);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Action find(@PathVariable("id") Integer id) {
        if (id == null) return null;

        return service.find(id);
    }

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    public boolean insert(@RequestBody Action action){
        if(action == null) return false;

        return service.insert(action);
    }

    @RequestMapping(value = "/update", method = {RequestMethod.PUT})
    public boolean update(@RequestBody Action action){
        if (action == null) return false;

        return service.update(action);
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE})
    public boolean delete(@RequestBody(required = false) Action action){
        if(action == null) return false;

        return service.delete(action);
    }
}