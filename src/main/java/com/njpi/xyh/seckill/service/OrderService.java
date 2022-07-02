package com.njpi.xyh.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.njpi.xyh.seckill.entity.Order;
import com.njpi.xyh.seckill.entity.User;
import com.njpi.xyh.seckill.vo.GoodsVo;

/**
 * (Order)表服务接口
 *
 * @author xyh
 * @since 2022-06-30 16:47:41
 */
public interface OrderService extends IService<Order> {

    Order seckill(User loginUser, GoodsVo goodsVo);

}

