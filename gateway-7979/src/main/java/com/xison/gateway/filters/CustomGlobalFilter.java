/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * 自定义全局filter
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-04 22:20
 */
@Configuration
public class CustomGlobalFilter implements GlobalFilter, Ordered {

    /**
     * 类似java web doFilter
     * exchange : 交换   request response   封装了 request response
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //http request对象
        ServerHttpRequest request = exchange.getRequest();
        //http response对象
        ServerHttpResponse response = exchange.getResponse();
        System.out.println("经过全局Filter处理.......");
        //放心filter继续向后执行
        Mono<Void> filter = chain.filter(exchange);
        System.out.println("响应回来Filter处理......");
        return filter;
    }

    /**
     * order 排序  int数字:当又多个filter的时候，用来指定filter执行顺序  默认顺序按照自然数字进行排序 , -1 在所有filter执行之前执行
     * @return
     */
    @Override
    public int getOrder() {
        return -1;
    }
}
