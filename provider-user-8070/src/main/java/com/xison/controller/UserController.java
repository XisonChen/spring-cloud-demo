/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.controller;

import com.xison.common.Result;
import com.xison.common.Results;
import com.xison.common.UserReq;
import com.xison.common.UserVO;
import com.xison.manager.UserManager;
import com.xison.mapper.entity.UserDO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cloud.client.ServiceInstance;
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
    public Result<UserVO> getbyid(@PathVariable Long id) {
        UserDO user = userManager.getById(id);
        return Results.success(new UserVO().setId(user.getId()).setName(user.getName()));
    }

    /**
     * 用来获取一些注册进来的微服务的消息
     * @return
     */
    @GetMapping("/discovery")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services = discoveryClient.getServices();
        //输出微服务的清单
        System.out.println("discovery=>:"+services);
        //得到一个具体的服务的信息,通过具体的微服务id，applicationName
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId()
            );
        }
        return this.discoveryClient;
    }
}
