package com.tp.common.exception;

/**
 *
 */
public class BizException extends RuntimeException {

    public BizException(String s) {
        super(s);
    }

    public BizException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BizException(Throwable throwable) {
        super(throwable);
    }

    public BizException() {

    }
}
