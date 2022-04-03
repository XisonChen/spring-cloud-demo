/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.eureka7072;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * TODO
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-03 18:38
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7072Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7072Application.class, args);
    }
}
