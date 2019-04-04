package com.cloud.ribbon.ribbon.controller;

import com.cloud.ribbon.ribbon.Entity.User;
import com.cloud.ribbon.ribbon.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HelloService helloService;


    @Autowired
    private DiscoveryClient client;

    @HystrixCommand//注解实现监控sayHello方法
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello() throws Exception{
        //模拟请求超时
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime:"+sleepTime);
        Thread.sleep(sleepTime);

        return helloService.sayHello();
    }

    @HystrixCommand(commandKey = "hello1")
    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "HELLO " + name;
    }

    @HystrixCommand(commandKey = "hello2")
    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public String hello(@RequestParam String name ,@RequestParam Integer age){
        return new User(name,age).toString();
    }

    @HystrixCommand(commandKey = "hello3")
    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public String hello(@RequestBody User user){
        return "HELLO "+ user.getName() + "," + user.getAge();
    }
}
