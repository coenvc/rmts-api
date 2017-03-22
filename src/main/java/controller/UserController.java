package controller;

import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import service.user.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private UserService service = appContext.getBean("userService", UserService.class);

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
}