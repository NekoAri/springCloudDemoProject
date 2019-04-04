package com.cloud.feign_consumer.service;

import com.cloud.feign_consumer.Entity.User;
import com.cloud.feign_consumer.service.impl.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ribbon-provider",fallback = HelloServiceFallback.class)
public interface HelloService {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello();

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    User hello(@RequestParam(value = "name") String name,@RequestParam(value = "age") Integer age);

    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
