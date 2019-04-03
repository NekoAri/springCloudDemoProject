package com.cloud.ribbon.consumer.ribbon_consumer.controller;

import com.cloud.ribbon.consumer.ribbon_consumer.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayGoodBye(){
        return helloService.sayHello();
    }
}
