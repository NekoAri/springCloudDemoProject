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


    @HystrixCommand//注解实现监控sayHello方法
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(@RequestParam String name) throws Exception{
        //模拟请求超时延时信息
        int sleepTime = new Random().nextInt(3000);
        Thread.sleep(sleepTime);
        return helloService.sayHello() + " " + name;
    }
}
