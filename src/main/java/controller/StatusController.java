package controller;

import model.status.Status;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import service.status.StatusService;

import java.util.List;

@RestController()
@RequestMapping("/status")
@CrossOrigin("*")
public class StatusController {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private StatusService service = appContext.getBean("statusService", StatusService.class);

    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public List getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Status find(@PathVariable("id") Integer id) {
        if (id == null) return null;

        return service.find(id);
    }

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    public boolean insert(@RequestBody Status status){
        if(status == null) return false;

        return service.insert(status);
    }

    @RequestMapping(value = "/update", method = {RequestMethod.PUT})
    public boolean update(@RequestBody Status status){
        if (status == null) return false;

        return service.update(status);
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE})
    public boolean delete(@RequestBody(required = false) Status status){
        if(status == null) return false;

        return service.delete(status);
    }



}
