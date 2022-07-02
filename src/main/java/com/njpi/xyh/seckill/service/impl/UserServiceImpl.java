package com.njpi.xyh.seckill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njpi.xyh.seckill.dao.UserDao;
import com.njpi.xyh.seckill.entity.User;
import com.njpi.xyh.seckill.exception.MyGlobalException;
import com.njpi.xyh.seckill.result.RespBean;
import com.njpi.xyh.seckill.result.RespBeanEnum;
import com.njpi.xyh.seckill.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 用户表(User)表服务实现类
 *
 * @author xyh
 * @since 2022-06-30 16:47:42
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Resource
    private HttpServletRequest request;

    @Resource
    private HttpServletResponse response;


    @Override
    public RespBean login(User user) {
        String mobile = user.getMobile();
        String password = user.getPassword();
        //1. 校验参数 使用Validated
        //2. 根据手机号判断是否存在登录用户
        User userDB = query().eq("mobile", mobile).one();
        if (userDB == null) {
            throw new MyGlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        // 3. 判断密码是否正确

        if (!password.equals(userDB.getPassword())) {
            throw new MyGlobalException(RespBeanEnum.LOGIN_ERROR);
        }

        // 4. cookie返回前端
        UUID token = UUID.randomUUID();
        // 用这个cookie 代表用户
        Cookie cookie = new Cookie("ticker",token+"");
        cookie.setDomain("localhost");
        cookie.setPath("/");
        //将当前登录用户保存到session中
        log.debug("存入到session中的token是:"+token);
        request.getSession().setAttribute(token+"",userDB);
        // 返回cookie
        response.addCookie(cookie);

        return RespBean.success(token);
    }
}

