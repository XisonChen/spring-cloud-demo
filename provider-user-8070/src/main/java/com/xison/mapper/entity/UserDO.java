/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.mapper.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * TODO
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-01 18:33
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class UserDO {

    private Long id;

    private String name;
}
