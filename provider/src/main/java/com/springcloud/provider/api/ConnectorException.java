package com.springcloud.provider.api;

public class ConnectorException extends Exception {

    private String code;

    public ConnectorException(String message) {
        super(message);
    }

    public ConnectorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectorException(String code, String message, Throwable cause) {
        super(message, cause);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
