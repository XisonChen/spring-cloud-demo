/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.user.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-03 20:54
 */
@Configuration
public class MyRule {

    public IRule myRule() {
        /**
         * IRule:
         * RoundRobinRule 轮询策略
         * RandomRule 随机策略
         * AvailabilityFilteringRule ： 会先过滤掉，跳闸，访问故障的服务~，对剩下的进行轮询~
         * RetryRule ： 会先按照轮询获取服务~，如果服务获取失败，则会在指定的时间内进行，重试
         */
        return new RandomRule();
    }
}
