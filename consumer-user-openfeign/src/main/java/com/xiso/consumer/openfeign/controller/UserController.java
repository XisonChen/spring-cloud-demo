/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xiso.consumer.openfeign.controller;

import com.xison.common.Result;
import com.xison.common.UserReq;
import com.xison.common.UserVO;
import com.xison.common.service.UserService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
 * @since 2022-04-03 21:25
 */
@RestController
@RequestMapping("/userconsumer/openfeign")
public class UserController {

    @Resource
    private RestTemplate restTemplate;
    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody UserReq req) {
        return this.userService.add(req);
    }

    @ResponseBody
    @PostMapping("/modify")
    public Result<Boolean> modify(@RequestBody UserReq req) {
        return this.userService.modify(req);
    }

    @ResponseBody
    @GetMapping("/userlist")
    public Result<List<UserVO>> userList() {
        return this.userService.userList();
    }

    @ResponseBody
    @GetMapping("/getbyid/{id}")
    public Result<UserVO> getbyid(@PathVariable(value = "id") Long id) {
        return this.userService.getbyid(id);
    }
}
