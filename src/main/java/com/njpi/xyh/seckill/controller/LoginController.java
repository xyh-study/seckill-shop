package com.njpi.xyh.seckill.controller;

import com.njpi.xyh.seckill.entity.User;
import com.njpi.xyh.seckill.result.RespBean;
import com.njpi.xyh.seckill.result.RespBeanEnum;
import com.njpi.xyh.seckill.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author: xyh
 * @create: 2022/6/30 16:38
 */
@Controller
@Slf4j
@RequestMapping("login")
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }


    @RequestMapping(value = "doLogin",method= RequestMethod.POST)
    @ResponseBody
    public RespBean doLogin(@Validated  User user){
        log.debug("{}",user);
        return userService.login(user);
}

}
