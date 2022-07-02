package com.njpi.xyh.seckill.config;

import com.njpi.xyh.seckill.controller.AuthenticationException;
import com.njpi.xyh.seckill.result.RespBeanEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: xyh
 * @create: 2022/6/30 22:11
 */
@Aspect
@Slf4j
@Component // 加入容器
public class SpringAopConfig {

    @Resource
    private HttpServletRequest request;

    @Before("@annotation(com.njpi.xyh.seckill.annotations.Authentication)")
    public void propertyAccess() {
        log.debug("进入权限认证------");

        if (request.getCookies() == null) {
            log.debug("没有携带cookie");
            // 抛出认证失败异常
            throw new AuthenticationException(RespBeanEnum.AUTHENTICATION_FAIL);
        }

        String token = "";
        // 获取前端带来的cook ie
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("ticker")) {
                token = cookie.getValue();
                log.debug("token ===== > "+token);
            }
        }

        if (token == null) {
            log.debug("cookie中没有ticker");
            // 抛出认证失败异常
            throw new AuthenticationException(RespBeanEnum.AUTHENTICATION_FAIL);
        }

        Object user_ticker = request.getSession().getAttribute(token + "");


        if (user_ticker == null) {
            log.debug("session 中没有当前用户");
            // 抛出认证失败异常
            throw new AuthenticationException(RespBeanEnum.AUTHENTICATION_FAIL);
        }

        request.getSession().setAttribute("loginUser",user_ticker);


    }

}
