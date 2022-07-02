package com.njpi.xyh.seckill.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;


/**
 * 秒杀商品表(SeckillGoods)表实体类
 *
 * @author xyh
 * @since 2022-06-30 16:47:41
 */
@SuppressWarnings("serial")
@TableName("t_seckill_goods")
public class SeckillGoods extends Model<SeckillGoods> {
    /**
     * 秒杀商品ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 商品ID
     */
    @TableField(value = "goods_id")
    private Long goodsId;

    /**
     * 秒杀家
     */
    @TableField(value = "seckill_price")
    private Double seckillPrice;

    /**
     * 库存数量
     */
    @TableField(value = "stock_count")
    private Integer stockCount;

    /**
     * 秒杀开始时间
     */
    @TableField(value = "start_date")
    private Date startDate;

    /**
     * 秒杀结束时间
     */
    @TableField(value = "end_date")
    private Date endDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Double getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(Double seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}

