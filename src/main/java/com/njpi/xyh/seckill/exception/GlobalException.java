package com.njpi.xyh.seckill.exception;

import com.njpi.xyh.seckill.controller.AuthenticationException;
import com.njpi.xyh.seckill.result.RespBean;
import com.njpi.xyh.seckill.result.RespBeanEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: xyh
 * @create: 2022/6/30 17:51
 */
@ControllerAdvice
@Slf4j
public class GlobalException {

    /**
     * 处理参数校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public RespBean BindException(BindException e) {
        for (ObjectError allError : e.getAllErrors()) {
            // 字段名称
            log.debug(allError.getObjectName());
            // 错误信息
            log.debug(allError.getDefaultMessage());
        }
        return RespBean.error(RespBeanEnum.BIND_ERROR);
    }

    /**
     * 处理全局的自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(MyGlobalException.class)
    @ResponseBody
    public RespBean BindException(MyGlobalException e) {
        return RespBean.error(e.getRespBeanEnum());
    }


    /**
     * 处理认证失败异常
     * @param e
     * @return
     */
    @ExceptionHandler(AuthenticationException.class)
    public String AuthenticationException(AuthenticationException e){
            return "redirect:/login/toLogin";
    }



}
