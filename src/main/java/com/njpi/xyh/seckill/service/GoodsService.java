package com.njpi.xyh.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.njpi.xyh.seckill.entity.Goods;
import com.njpi.xyh.seckill.vo.GoodsVo;

import java.util.List;

/**
 * 商品表(Goods)表服务接口
 *
 * @author xyh
 * @since 2022-06-30 16:47:39
 */
public interface GoodsService extends IService<Goods> {

    List<GoodsVo> queryGoodsVo();


    GoodsVo queryGoodsVoById(Integer id);
}

