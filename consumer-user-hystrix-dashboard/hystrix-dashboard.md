# Hystrix Dashboard 流监控
Hystrix Dashboard的一个主要优点是它收集了关于每个HystrixCommand的一组度量。Hystrix仪表板以高效的方式显示每个断路器的运行状况


给要被监控的服务提供者（springcloud-provider-dept-hystrix-8001模块）下的主启动类添加hystrix依赖和监控

`
<dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
 </dependency>
 `


流监控
被监控的应用ip:端口/actuator/hystrix.stream