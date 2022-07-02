package com.njpi.xyh.seckill.exception;

import com.njpi.xyh.seckill.result.RespBeanEnum;

/**
 * @author: xyh
 * @create: 2022/6/30 18:23
 */
public class MyGlobalException extends RuntimeException {

    private RespBeanEnum respBeanEnum;

    public MyGlobalException() {
    }

    public MyGlobalException(RespBeanEnum respBeanEnum) {
        this.respBeanEnum = respBeanEnum;
    }

    public MyGlobalException(String message) {
        super(message);
    }

    public MyGlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyGlobalException(Throwable cause) {
        super(cause);
    }

    public MyGlobalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RespBeanEnum getRespBeanEnum() {
        return respBeanEnum;
    }

    public void setRespBeanEnum(RespBeanEnum respBeanEnum) {
        this.respBeanEnum = respBeanEnum;
    }
}
