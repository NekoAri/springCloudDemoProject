springCloudDemoProject
=============================================
##### SpringCloudDemo&lt;&lt;create on IntelliJ IDEA>> Some demofunctions of SpringCloud.
## 基本环境
>* IDE:IntelliJ IDEA
>* JDK:11.0.2
>* rabbitMQ:3.7.1
>* kfka:2.12-2.2.0
>* zookeeper: kafka自带
---------------------------------------------
>运行前需要检查配置端口号是否被占用！！<Br/>
----------------------------------------------
MODULE信息
---------------------------------------------
>## api_gateway 
>>* Zuul网关，实现URL转发
>
>## eureka
>>* Eureka注册中心
>
>## feign_consumer 
>>* feign消费者，实现ribbon服务提供者声明调用
>
>## hello_service_api
>>* hello_service实体类无需运行，只需在运行前构建
>
>## hystrix 
>>* 结合@HystrixCommand实现方法监控窗口
>
>## ribbon 
>>* 实现ribbon服务提供者
>
>## ribbon_consumer
>>* 实现ribbon服务消费者
>
>## turbine
>>* 实现集群监控
>
>## config_server
>>* 分布式配置中心服务
>>* 添加消息总线配置
>>>* 利用rabbitMQ总线（已被注释）
>>>* 利用zookeeper和kafka总线（目前配置）
>
>## config_client
>>* 千万注意properties文件内配置信息的顺序！！！注意启用上下文规则！！！（被坑了很久一直起不来，已修正）
>>* 分布式配置中心客户端
>>* 添加消息总线配置
>>>* 利用rabbitMQ总线（已被注释）
>>>* 利用zookeeper和kafka总线（目前配置）
>
>## config_repo
>>* 分布式配置文件
>
>## rabbitmq_hello
>>* rabbitMQ消息总线配置
-------------------------------------------------------
