/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.mapper;

import com.xison.mapper.entity.UserDO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-01 18:32
 */
@Mapper
@Repository
public interface UserMapper {

    int insert(@Param("user") UserDO user);

    int updateById(@Param("user") UserDO user);

    List<UserDO> allList();

    UserDO getById(@Param("id") Long id);
}
