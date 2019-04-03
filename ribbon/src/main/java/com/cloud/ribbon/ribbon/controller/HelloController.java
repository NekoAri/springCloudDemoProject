package com.cloud.ribbon.ribbon.controller;

import com.cloud.ribbon.ribbon.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;
   // @Configuration
  //  @RibbonClient(name = "ribbon-provider",configuration = HelloServiceConfiguration.class)
  //  public class RibbonConfiguration{}
    @HystrixCommand
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(@RequestParam String name) throws Exception{

        int sleepTime = new Random().nextInt(3000);
        Thread.sleep(sleepTime);
        //ServiceInstance instance = client.getLocalhostServiceInstance();
        return helloService.sayHello() + " " + name;
    }
}
