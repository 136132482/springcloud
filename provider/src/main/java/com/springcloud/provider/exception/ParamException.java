package com.springcloud.provider.exception;

/**
 * 获取参数异常
 * Created by odfly on 2017/1/4.
 */
public class ParamException extends RuntimeException {
    private static final long serialVersionUID = 8639609611794399340L;

    /**
     * @param message
     */
    public ParamException(String message) {
        super(message);
    }

    public ParamException(Throwable throwable) {
        super(throwable);
    }

    public ParamException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
