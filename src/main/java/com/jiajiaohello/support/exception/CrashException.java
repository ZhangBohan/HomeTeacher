package com.jiajiaohello.support.exception;

/**
 * User: bohan
 * Date: 9/16/14
 * Time: 11:29 AM
 */
public class CrashException extends CommonException {
    public CrashException() {
    }

    public CrashException(String message) {
        super(message);
    }

    public CrashException(String message, Throwable cause) {
        super(message, cause);
    }

    public CrashException(Throwable cause) {
        super(cause);
    }

    public CrashException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
