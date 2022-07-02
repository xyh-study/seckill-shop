package com.njpi.xyh.seckill.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


/**
 * 商品表(Goods)表实体类
 *
 * @author xyh
 * @since 2022-06-30 16:47:37
 */
@SuppressWarnings("serial")
@TableName("t_goods")
public class Goods extends Model<Goods> {
    /**
     * 商品ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 商品名称
     */
    @TableField(value = "goods_name")
    private String goodsName;

    /**
     * 商品标题
     */
    @TableField(value = "goods_title")
    private String goodsTitle;

    /**
     * 商品图片
     */
    @TableField(value = "goods_img")
    private String goodsImg;

    /**
     * 商品详情
     */
    @TableField(value = "goods_detail")
    private String goodsDetail;

    /**
     * 商品价格
     */
    @TableField(value = "goods_price")
    private Double goodsPrice;

    /**
     * 商品库存，-1表示没有限制
     */
    @TableField(value = "goods_stock")
    private Integer goodsStock;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

}

