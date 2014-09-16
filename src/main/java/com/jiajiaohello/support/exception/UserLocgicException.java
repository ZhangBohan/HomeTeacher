package com.jiajiaohello.support.exception;

/**
 * User: bohan
 * Date: 9/16/14
 * Time: 11:22 AM
 */
public class UserLocgicException extends CommonException {
    public UserLocgicException() {
    }

    public UserLocgicException(String message) {
        super(message);
    }

    public UserLocgicException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLocgicException(Throwable cause) {
        super(cause);
    }

    public UserLocgicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
