package com.njpi.xyh.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.njpi.xyh.seckill.entity.User;
import com.njpi.xyh.seckill.result.RespBean;

/**
 * 用户表(User)表服务接口
 *
 * @author xyh
 * @since 2022-06-30 16:47:42
 */
public interface UserService extends IService<User> {

    RespBean login(User user);
}

