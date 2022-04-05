/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * TODO
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-05 14:56
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServer3345Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer3345Application.class, args);
    }
}
