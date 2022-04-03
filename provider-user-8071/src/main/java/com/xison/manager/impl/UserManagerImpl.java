/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.manager.impl;

import com.xison.manager.UserManager;
import com.xison.mapper.UserMapper;
import com.xison.mapper.entity.UserDO;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-01 18:41
 */
@Component
public class UserManagerImpl implements UserManager {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean insert(UserDO user) {
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean updateById(UserDO user) {
        return userMapper.updateById(user) > 0;
    }

    @Override
    public List<UserDO> allList() {
        return userMapper.allList();
    }

    @Override
    public UserDO getById(Long id) {
        return userMapper.getById(id);
    }
}
