package com.njpi.xyh.seckill.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.njpi.xyh.seckill.annotations.Authentication;
import com.njpi.xyh.seckill.entity.Order;
import com.njpi.xyh.seckill.entity.SeckillOrder;
import com.njpi.xyh.seckill.entity.User;
import com.njpi.xyh.seckill.result.RespBean;
import com.njpi.xyh.seckill.result.RespBeanEnum;
import com.njpi.xyh.seckill.service.GoodsService;
import com.njpi.xyh.seckill.service.OrderService;
import com.njpi.xyh.seckill.service.SeckillOrderService;
import com.njpi.xyh.seckill.vo.GoodsVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: xyh
 * @create: 2022/7/1 13:39
 */

@Controller
@RequestMapping("seckill")
public class seckillController {

    @Resource
    private GoodsService goodsService;


    @Resource
    private HttpServletRequest request;

    @Resource
    private HttpServletResponse response;

    @Resource
    private HttpSession session;

    @Resource
    private SeckillOrderService seckillOrderService;


    @Resource
    private OrderService orderService;
    @GetMapping("doSeckill")
    @Authentication() // 判断是否登录
    public String doSeckill(Integer id) {
        GoodsVo goodsVo = goodsService.queryGoodsVoById(id);
        User loginUser = (User) session.getAttribute("loginUser");
        // 判断库存
        if (goodsVo.getStockCount() < 1) {
            request.setAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
            return "secKillFail";
        }

        // 判断是否重复抢购 秒杀订单表中已经存在当前用户和当前商品 就代表是重复
        SeckillOrder one = seckillOrderService.query().eq("goods_id", id).eq("user_id",loginUser.getId()).one();
        if (one != null) {
            request.setAttribute("errmsg", RespBeanEnum.REPEATE_ERROR.getMessage());
            return "secKillFail";
        }


        // 生成订单
      Order order  =  orderService.seckill(loginUser,goodsVo);
        request.setAttribute("order",order);
        request.setAttribute("goods",goodsVo);


        request.setAttribute("user", loginUser);


        return null;
    }


}
