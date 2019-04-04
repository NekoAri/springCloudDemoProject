package com.cloud.ribbon.consumer.ribbon_consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback",commandKey = "helloKsy")
    public String sayHello(){
        String msg = restTemplate.getForObject("http://ribbon-provider/hello?name=bighead",String.class);
        return msg;
    }

    public String helloFallback(){
        return "error";
    }
}
