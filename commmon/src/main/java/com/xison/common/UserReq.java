/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.common;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * UserVO
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-01 18:57
 */
@Getter
@Setter
@ToString
public class UserReq implements Serializable {

    private static final long serialVersionUID = 7920011651571675809L;
    private Long id;
    private String name;
}
