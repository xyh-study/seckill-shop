package com.njpi.xyh.seckill.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.njpi.xyh.seckill.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import com.njpi.xyh.seckill.entity.Goods;
import org.springframework.stereotype.Component;

/**
 * 商品表(Goods)表数据库访问层
 *
 * @author xyh
 * @since 2022-06-30 16:47:37
 */
public interface GoodsDao extends BaseMapper<Goods> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Goods> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Goods> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Goods> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Goods> entities);

    List<GoodsVo> selectGoodsVo();


    GoodsVo queryGoodsVoById(Integer id);
}

