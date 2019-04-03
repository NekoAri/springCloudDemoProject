package com.cloud.ribbon.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String sayHello(){
        return "hello world";
    }
}
