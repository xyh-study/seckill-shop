package com.njpi.xyh.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njpi.xyh.seckill.dao.SeckillOrderDao;
import com.njpi.xyh.seckill.entity.SeckillOrder;
import com.njpi.xyh.seckill.service.SeckillOrderService;
import org.springframework.stereotype.Service;

/**
 * 秒杀订单表(SeckillOrder)表服务实现类
 *
 * @author xyh
 * @since 2022-06-30 16:47:41
 */
@Service("seckillOrderService")
public class SeckillOrderServiceImpl extends ServiceImpl<SeckillOrderDao, SeckillOrder> implements SeckillOrderService {

}

