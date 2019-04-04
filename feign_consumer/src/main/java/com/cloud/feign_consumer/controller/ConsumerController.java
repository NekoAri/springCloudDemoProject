package com.cloud.feign_consumer.controller;

import com.cloud.feign_consumer.Entity.User;
import com.cloud.feign_consumer.service.HelloService;
import com.cloud.feign_consumer.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    HelloService helloService;

    @Autowired
    RefactorHelloService refactorHelloService;




    @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2",method = RequestMethod.GET)
    public String helloConsumer2(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(helloService.hello()).append("\n");
        stringBuilder.append(helloService.hello("LALA")).append("\n");
        stringBuilder.append(helloService.hello("LALA",26)).append("\n");
        stringBuilder.append(helloService.hello(new User("LALA",30))).append("\n");
        return stringBuilder.toString();
    }
    @RequestMapping(value = "feign-consumer3",method = RequestMethod.GET)
    public String helloConsumer3(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(refactorHelloService.hello("MIMI")).append("\n");
        stringBuilder.append(refactorHelloService.hello("MIMI",23)).append("\n");
        stringBuilder.append(refactorHelloService.hello(new com.cloud.hello_service_api.Entity.User("MIMI",23).toString())).append("\n");
        return stringBuilder.toString();
    }
}
