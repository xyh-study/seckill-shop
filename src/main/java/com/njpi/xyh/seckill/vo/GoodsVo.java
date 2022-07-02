package com.njpi.xyh.seckill.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.njpi.xyh.seckill.entity.Goods;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 返回商品的Vo对象
 * @author: xyh
 * @create: 2022/7/1 12:32
 */
@Data
@NoArgsConstructor
public class GoodsVo extends Goods {

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

}
