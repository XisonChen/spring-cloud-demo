/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.common.service;

import com.xison.common.Result;
import com.xison.common.UserReq;
import com.xison.common.UserVO;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * FeignClient
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-03 21:18
 */
@Service
@FeignClient(value = "PROVIDER-USER", fallbackFactory = UserFallbackFactory.class)
public interface UserService {

    @PostMapping("/userprovider/user/add")
    Result<Boolean> add(UserReq req);

    @PostMapping("/userprovider/user/modify")
    Result<Boolean> modify(UserReq req);

    @GetMapping("/userprovider/user/userlist")
    Result<List<UserVO>> userList();

    @GetMapping("/userprovider/user/getbyid/{id}")
    Result<UserVO> getbyid(@PathVariable("id") Long id);
}
