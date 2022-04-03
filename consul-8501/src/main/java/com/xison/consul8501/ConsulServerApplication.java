/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.consul8501;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * EnableDiscoveryClient注解
 * 作用：通用服务注册客户端注解 可以对consulClient zookeeperClient eurekaClient都生效
 * @author chenjj
 * @version V1.0
 * @since 2022-04-03 19:27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulServerApplication.class, args);
    }
}
