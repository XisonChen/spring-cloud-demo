/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-01 18:30
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ProviderUser8071Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderUser8071Application.class);
    }
}
