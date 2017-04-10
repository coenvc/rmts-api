package controller;

import model.ActionType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import service.actionType.ActionTypeService;

import java.util.List;

@RestController()
@RequestMapping("/actionType")
@CrossOrigin("*")
public class ActionTypeController {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private ActionTypeService service = appContext.getBean("actionTypeService", ActionTypeService.class);

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
    public boolean insert(@RequestBody ActionType actionType){
        if(actionType == null) return false;

        return service.insert(actionType);
    }

    @RequestMapping(value = "/update", method = {RequestMethod.PUT})
    public boolean update(@RequestBody ActionType actionType){
        if (actionType == null) return false;

        return service.update(actionType);
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE})
    public boolean delete(@RequestBody(required = false) ActionType actionType){
        if(actionType == null) return false;

        return service.delete(actionType);
    }
}
