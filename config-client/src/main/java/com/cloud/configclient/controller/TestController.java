package com.cloud.configclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    /**
     * 通过@Value注解绑定注入，获取配置信息
     */
    @Value("${from}")
    private String from;

    @RequestMapping("/from")
    public String from(){
        return this.from;
    }

    /**
     * 通过Environment对象获取配置信息
    @Autowired
    private Environment env;

    @RequestMapping("/fromEnv")
    public String fromEnv(){
        return env.getProperty("from","undefined");
    }*/
}
