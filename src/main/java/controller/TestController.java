package controller;

import model.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TestService;

@RestController
public class TestController {

    @RequestMapping("/test")
    public Test test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        TestService customerService = applicationContext.getBean("testService", TestService.class);

        return customerService.find(1);
    }
}
