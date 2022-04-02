/*
 * Copyright (c) 2001-2022 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.xison.common;

/**
 * TODO
 *
 * @author chenjj
 * @version V1.0
 * @since 2022-04-01 19:05
 */
public class Results {

    public static <T> Result<T> success(T data) {
        return new Result<>("0", data);
    }

    public static <T> Result<T> error(String code, T data) {
        return new Result<>(code, data);
    }
}
