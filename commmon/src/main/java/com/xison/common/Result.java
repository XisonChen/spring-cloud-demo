/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.common;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-01 18:59
 */
@Setter
@Getter
public class Result<T> {

    private String code;

    private T data;

    public Result() {
    }

    public Result(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result<T> success(T data) {
        return new Result<>("0", data);
    }
}
