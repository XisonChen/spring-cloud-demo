/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.common.service;

import com.xison.common.Result;
import com.xison.common.Results;
import com.xison.common.UserReq;
import com.xison.common.UserVO;

import java.util.List;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-03 22:27
 */
@Component
public class UserFallbackFactory  implements FallbackFactory {
    @Override
    public Object create(Throwable cause) {
        return new UserService() {
            @Override
            public Result<Boolean> add(UserReq req) {
                return null;
            }

            @Override
            public Result<Boolean> modify(UserReq req) {
                return null;
            }

            @Override
            public Result<List<UserVO>> userList() {
                return null;
            }

            @Override
            public Result<UserVO> getbyid(Long id) {
                return Results.success(new UserVO().setId(id).setName("id=>" + id + "没有对应信息，null~~@Hystrix"));
            }
        };
    }
}
