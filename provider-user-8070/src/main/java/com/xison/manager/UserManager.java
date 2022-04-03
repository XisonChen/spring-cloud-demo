/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.manager;

import com.xison.mapper.entity.UserDO;

import java.util.List;

/**
 * TODO
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-01 18:41
 */
public interface UserManager {
    boolean insert(UserDO user);

    boolean updateById(UserDO user);

    List<UserDO> allList();

    UserDO getById(Long id);
}
