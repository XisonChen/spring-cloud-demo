/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.user.consumer;

import com.xison.user.rule.MyRule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * EnableEurekaClient注解 eureka客户端
 * Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关心ip地址和端口号
 *
 * RibbonClient 开启负载均衡，并指定自定义策略
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-02 10:54
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "PROVIDER-USER", configuration = MyRule.class)
public class ConsumerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerUserApplication.class);
    }
}
