package com.xison.eureka7073;/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */

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
public class EurekaServer7073Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7073Application.class, args);
    }
}
