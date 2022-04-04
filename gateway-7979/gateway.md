# Gateway组件简介
Gateway提供了一个在springmvc之上构建API网关的库。springcloudgateway旨在提供一种简单而有效的方法来路由到api，并为api提供横切关注点，比如：安全性、监控/度量和弹性。

1.特性
* 基于springboot2.x 和 spring webFlux 和 Reactor 构建 响应式异步非阻塞IO模型
* 动态路由
* 请求过滤

网关 gateway = 断言predicate + 过滤（后置filler）
* 断言：当请求到达网关时，网关前置处理
* 过滤：当请求满足断言的所有条件之后，会向后端服务转发，在向后端服务转发之前会经过一些过滤