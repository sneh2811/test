package com.eduboooks.test.controllers.errors;

/**
 * Created by sunflower on 10/23/17.
 */
public class GlobalError extends RuntimeException {

    private final String message;

    private final boolean status;

    private final int httpStatus;

    public GlobalError(String message, boolean status,int httpStatus) {
        this.message = message;
        this.status = status;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public boolean getStatus() {
        return status;
    }
}
