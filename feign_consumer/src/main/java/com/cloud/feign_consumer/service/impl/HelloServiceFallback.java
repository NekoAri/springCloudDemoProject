package com.cloud.feign_consumer.service.impl;

import com.cloud.feign_consumer.Entity.User;
import com.cloud.feign_consumer.service.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("Unknown",0);
    }

    @Override
    public String hello(User user) {
        return "error";
    }
}
