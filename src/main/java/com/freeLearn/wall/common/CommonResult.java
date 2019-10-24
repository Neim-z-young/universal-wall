package com.freeLearn.wall.common;

/**
 * 通用返回对象
 * 避免使用ResponseEntity<T>对象，因为该对象不适合部分认证场景。
 */
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;

    protected CommonResult(){}

}
