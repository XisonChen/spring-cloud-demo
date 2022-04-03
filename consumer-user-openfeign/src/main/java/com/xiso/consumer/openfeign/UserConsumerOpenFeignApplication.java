/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xiso.consumer.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 开始openFeign调用
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-03 21:30
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.xison.common.service")
public class UserConsumerOpenFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserConsumerOpenFeignApplication.class, args);
    }
}
