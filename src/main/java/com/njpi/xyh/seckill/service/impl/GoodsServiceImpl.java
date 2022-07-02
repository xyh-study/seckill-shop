package com.njpi.xyh.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njpi.xyh.seckill.dao.GoodsDao;
import com.njpi.xyh.seckill.entity.Goods;
import com.njpi.xyh.seckill.service.GoodsService;
import com.njpi.xyh.seckill.vo.GoodsVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品表(Goods)表服务实现类
 *
 * @author xyh
 * @since 2022-06-30 16:47:40
 */
@Service("goodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, Goods> implements GoodsService {

    @Resource
    private GoodsDao goodsDao;

    @Override
    public List<GoodsVo> queryGoodsVo() {
        List<GoodsVo> goodsVos = goodsDao.selectGoodsVo();
        return goodsVos;
    }

    @Override
    public GoodsVo queryGoodsVoById(Integer id) {

        return goodsDao.queryGoodsVoById(id);
    }
}

