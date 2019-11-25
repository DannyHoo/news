package com.danny.news.client.common.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author huyuyang
 * @email yuyang.hu@opay-inc.com
 * @date 2019/11/21下午10:18
 */
@Data
@Accessors(chain = true)
public class Result<T> {

    private int code;
    private String message;
    private T data;

    public static <T> Result<T> build(int code, String message) {
        return new Result<T>().setCode(code).setMessage(message);
    }

    public static <T> Result<T> build(int code, String message, T data) {
        return new Result<T>().setCode(code).setMessage(message).setData(data);
    }

    public static <T> Result<T> buildSuccess(T data) {
        return new Result<T>().setCode(100000).setMessage("success").setData(data);

    }
}
