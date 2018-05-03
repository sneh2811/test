package com.eduboooks.test.controllers.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for HTTP headers creation.
 */
public final class BodyUtil {


    public String getMessage() {


        return message;
    }

    public void setMessage(String message) {
        this.message = message;
}

    private String message = null;


    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    private Map<String,Object> body = new HashMap<>();


    public BodyUtil() {
    }


}
