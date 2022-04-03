/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xison.common.Result;
import com.xison.common.Results;
import com.xison.common.UserReq;
import com.xison.common.UserVO;
import com.xison.manager.UserManager;
import com.xison.mapper.entity.UserDO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-01 18:54
 */
@RestController
@RequestMapping("/userprovider/user")
public class UserController {

    @Resource
    private UserManager userManager;
    @Resource
    private DiscoveryClient discoveryClient;

    @ResponseBody
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody UserReq req) {
        return Results.success(userManager.insert(new UserDO().setName(req.getName())));
    }

    @ResponseBody
    @PostMapping("/modify")
    public Result<Boolean> modify(@RequestBody UserReq req) {
        return Results.success(userManager.updateById(new UserDO().setId(req.getId()).setName(req.getName())));
    }

    @ResponseBody
    @GetMapping("/userlist")
    public Result<List<UserVO>> userList() {
        List<UserDO> userList = userManager.allList();
        List<UserVO> resultList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(userList)) {
            userList.forEach(e -> resultList.add(new UserVO().setId(e.getId()).setName(e.getName())));
        }
        return Results.success(resultList);
    }

    @GetMapping("/getbyid/{id}")
    //熔断，假设调用这个方法出现错误或者异常导致失败了，就调用里面设置的备选方法
    @HystrixCommand(fallbackMethod = "fallbackGetById")
    public Result<UserVO> getById(@PathVariable("id") Long id) {
        UserDO user = userManager.getById(id);
        if (user == null) {
            throw new RuntimeException("id=>" + id + "不存在该用户，或者信息无法找到");
        }
        return Results.success(new UserVO().setId(user.getId()).setName(user.getName()));
    }

    /**
     * 降级方法
     */
    public Result<UserVO> fallbackGetById(@PathVariable("id") Long id) {
        return Results.success(new UserVO().setId(id).setName("id=>" + id + "没有对应信息，null~~@Hystrix"));
    }

}
