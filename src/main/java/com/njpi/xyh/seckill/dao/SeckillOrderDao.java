package com.njpi.xyh.seckill.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.njpi.xyh.seckill.entity.SeckillOrder;

/**
 * 秒杀订单表(SeckillOrder)表数据库访问层
 *
 * @author xyh
 * @since 2022-06-30 16:47:41
 */
public interface SeckillOrderDao extends BaseMapper<SeckillOrder> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SeckillOrder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SeckillOrder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SeckillOrder> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SeckillOrder> entities);

}

