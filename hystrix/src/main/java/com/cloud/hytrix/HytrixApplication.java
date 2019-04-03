package com.cloud.hytrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/*声明Hystrix监视窗应用，实现服务状态监视*/
@EnableHystrixDashboard

@SpringBootApplication
public class HytrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HytrixApplication.class, args);
    }

}
