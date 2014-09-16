package com.jiajiaohello.support.exception;

/**
 * User: bohan
 * Date: 9/16/14
 * Time: 10:59 AM
 */

public class APIException extends CommonException {
    public APIException() {
    }

    public APIException(String message) {
        super(message);
    }

    public APIException(String message, Throwable cause) {
        super(message, cause);
    }

    public APIException(Throwable cause) {
        super(cause);
    }

    public APIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
