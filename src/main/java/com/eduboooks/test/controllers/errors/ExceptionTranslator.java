package com.eduboooks.test.controllers.errors;

import com.eduboooks.test.controllers.vm.CustomeErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.NoSuchElementException;

/**
 * Controller advice to translate the server side exceptions to client-friendly json structures.
 * The error response follows RFC7807 - Problem Details for HTTP APIs (https://tools.ietf.org/html/rfc7807)
 */
@ControllerAdvice
public class ExceptionTranslator   {

    /**
     * Post-process Problem payload to add the message key for front-end if needed
     */


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity badRequestException(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomeErrorMessage("Request Parameter Invalid",false));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity jwtTokenError() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomeErrorMessage("Session Expired, Please Login.",false));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity authenticate() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new CustomeErrorMessage("Session Expired, Please Login.",false));
    }


    @ExceptionHandler(GlobalError.class)
    @ResponseBody
    public ResponseEntity<CustomeErrorMessage> customException(GlobalError ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(new CustomeErrorMessage(ex.getMessage(),false));
    }
}
