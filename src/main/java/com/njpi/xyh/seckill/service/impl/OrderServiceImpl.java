package com.njpi.xyh.seckill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njpi.xyh.seckill.dao.OrderDao;
import com.njpi.xyh.seckill.entity.Order;
import com.njpi.xyh.seckill.entity.SeckillGoods;
import com.njpi.xyh.seckill.entity.User;
import com.njpi.xyh.seckill.service.OrderService;
import com.njpi.xyh.seckill.service.SeckillGoodsService;
import com.njpi.xyh.seckill.vo.GoodsVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (Order)表服务实现类
 *
 * @author xyh
 * @since 2022-06-30 16:47:41
 */
@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

    @Resource
    private SeckillGoodsService seckillGoodsService;

    @Override
    public Order seckill(User loginUser, GoodsVo goodsVo) {
        // 获取秒杀商品
        SeckillGoods seckillGoods = seckillGoodsService.getOne(new QueryWrapper<SeckillGoods>().eq("goods_id", goodsVo.getId()));

        // 减库存
        seckillGoods.setStockCount(seckillGoods.getStockCount()-1);
        seckillGoodsService.updateById(seckillGoods);

        // 创建订单表
        Order order = Order.builder().userId(loginUser.getId()).goodsId(goodsVo.getId()).deliveryAddrId(0L).goodsName(goodsVo.getGoodsName())
                .goodsCount(1).goodsPrice(seckillGoods.getSeckillPrice()).orderChannel(1).createDate(new Date()).build();

        baseMapper.insert(order);

        // 生成秒杀订单


        return null;
    }
}

