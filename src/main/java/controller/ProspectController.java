package controller;

import com.google.gson.Gson;
import model.prospect.Prospect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.prospect.ProspectService;
import springfox.documentation.spring.web.json.Json;

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

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Prospect find(@PathVariable("id") Integer id) {
        if (id == null) return null;

        return service.find(id);
    }

    @RequestMapping(value = "/update", method = {RequestMethod.PUT})
    public boolean update(@RequestBody Prospect prospect){
        if (prospect == null) return false;

        return service.update(prospect);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody Prospect prospect) {
        try {
            service.insert(prospect);
            return new ResponseEntity<String>("true", HttpStatus.OK);
        } catch (Exception e) {
            Gson gson = new Gson();
            return new ResponseEntity<String>(gson.toJson(e), HttpStatus.BAD_REQUEST);
        }
    }
}
