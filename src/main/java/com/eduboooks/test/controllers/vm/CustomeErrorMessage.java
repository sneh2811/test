package com.eduboooks.test.controllers.vm;

/**
 * View Model object for storing a user's credentials.
 */
public class CustomeErrorMessage {

    private String message;

    private boolean status;

    public CustomeErrorMessage(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
