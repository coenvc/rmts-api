package controller;

import model.Prospect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import service.prospect.ProspectService;

import java.util.List;

@RestController()
@RequestMapping("/prospect")
@CrossOrigin("*")
public class ProspectController {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private ProspectService service = appContext.getBean("prospectService", ProspectService.class);

    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public List getAll() {
        return service.getAll();
    }

    @RequestMapping("/{id}")
    public Prospect find(@PathVariable("id") Integer id) {
        if (id == null) return null;

        return service.find(id);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public boolean register(@RequestBody Prospect prospect) {
        return service.insert(prospect);
    }
}
