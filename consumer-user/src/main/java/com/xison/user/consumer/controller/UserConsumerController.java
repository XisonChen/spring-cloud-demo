/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.user.consumer.controller;

import com.xison.common.Result;
import com.xison.common.UserReq;
import com.xison.common.UserVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-02 10:58
 */
@RestController
@RequestMapping("/userconsumer/user")
public class UserConsumerController {

    @Resource
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://127.0.0.1:8081/userprovider/user";

    @ResponseBody
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody UserReq req) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/add", req, Result.class);
    }

    @ResponseBody
    @PostMapping("/modify")
    public Result<Boolean> modify(@RequestBody UserReq req) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/modify", req, Result.class);
    }

    @ResponseBody
    @GetMapping("/userlist")
    public Result<List<UserVO>> userList() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/userlist", Result.class);
    }

    @ResponseBody
    @GetMapping("/getbyid")
    public Result<UserVO> getbyid(@RequestBody UserReq req) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/getbyid", Result.class);
    }
}
