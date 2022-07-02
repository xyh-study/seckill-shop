package com.njpi.xyh.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njpi.xyh.seckill.dao.SeckillGoodsDao;
import com.njpi.xyh.seckill.entity.SeckillGoods;
import com.njpi.xyh.seckill.service.SeckillGoodsService;
import org.springframework.stereotype.Service;

/**
 * 秒杀商品表(SeckillGoods)表服务实现类
 *
 * @author xyh
 * @since 2022-06-30 16:47:41
 */
@Service("seckillGoodsService")
public class SeckillGoodsServiceImpl extends ServiceImpl<SeckillGoodsDao, SeckillGoods> implements SeckillGoodsService {

}

