package com.springcloud.provider.exception;

/**
 * Created by odfly on 2017/1/4.
 */
public class RunException extends RuntimeException {
    private static final long serialVersionUID = 8639609611794399340L;

    /**
     * @param message
     */
    public RunException(String message) {
        super(message);
    }

    public RunException(Throwable throwable) {
        super(throwable);
    }

    public RunException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
