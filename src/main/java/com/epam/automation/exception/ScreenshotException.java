package com.epam.automation.exception;

public class ScreenshotException extends RuntimeException {
    public ScreenshotException() {
        super();
    }

    public ScreenshotException(String message) {
        super(message);
    }

    public ScreenshotException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScreenshotException(Throwable cause) {
        super(cause);
    }

    protected ScreenshotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
