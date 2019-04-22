package com.springcloud.provider.moudle.entity;


import lombok.Data;

@Data
public class Result<T> {

    //消息
    private  String msg;

    //错误码
    private Integer code;

    //内容
    private T data;
}
