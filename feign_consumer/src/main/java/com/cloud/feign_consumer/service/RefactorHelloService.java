package com.cloud.feign_consumer.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("ribbon-provider")
public interface RefactorHelloService extends com.cloud.hello_service_api.service.HelloService{
}
