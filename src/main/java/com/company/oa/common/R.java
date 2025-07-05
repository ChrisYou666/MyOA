package com.company.oa.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 全局统一返回体
 *
 * @param <T> 响应数据类型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {
    /**
     * 返回码：0=成功，非0=异常
     */
    private int code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 成功，无数据
     */
    public static <T> R<T> ok() {
        return new R<>(0, "success", null);
    }

    /**
     * 成功，带数据
     */
    public static <T> R<T> ok(T data) {
        return new R<>(0, "success", data);
    }

    /**
     * 成功，自定义消息与数据
     */
    public static <T> R<T> ok(String msg, T data) {
        return new R<>(0, msg, data);
    }

    /**
     * 失败，默认消息
     */
    public static <T> R<T> error() {
        return new R<>(-1, "error", null);
    }

    /**
     * 失败，自定义消息
     */
    public static <T> R<T> error(String msg) {
        return new R<>(-1, msg, null);
    }

    /**
     * 失败，自定义码与消息
     */
    public static <T> R<T> error(int code, String msg) {
        return new R<>(code, msg, null);
    }
}