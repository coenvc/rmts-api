package controller;

import data.crud.CrudService;
import model.user.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.user.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private UserService service = appContext.getBean("userService", UserService.class);
    private CrudService crudService = appContext.getBean("crudService", CrudService.class);

    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public List all() {
        return service.getAll();
    }

    @RequestMapping("/{id}/**")
    public User find(@PathVariable("id") Integer id) {
        if (id == null) return null;
        return service.find(id);
    }

    @RequestMapping(value = "/login", method ={RequestMethod.POST})
    public User login(@RequestBody Map<String, String> values) {
        return service.login(values.get("username"), values.get("password"));
    }

    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public ResponseEntity<String> register(@RequestBody User user) {
        return crudService.insert(user);
    }
}