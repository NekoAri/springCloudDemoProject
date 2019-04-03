package com.cloud.ribbon.consumer.ribbon_consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    //添加Hystrix监控注解
    @HystrixCommand(fallbackMethod = "helloFallback",commandKey = "helloKsy")
    public String sayHello(){
        //请求ribbon-provider服务提供者进行服务消费
        String msg = restTemplate.getForObject("http://ribbon-provider/hello?name=bighead",String.class);
        return msg;
    }

    //服务异常执行代码
    public String helloFallback(){
        return "error";
    }
}
