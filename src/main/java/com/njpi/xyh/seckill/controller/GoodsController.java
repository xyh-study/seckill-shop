package com.njpi.xyh.seckill.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.njpi.xyh.seckill.annotations.Authentication;
import com.njpi.xyh.seckill.entity.Goods;
import com.njpi.xyh.seckill.service.GoodsService;
import com.njpi.xyh.seckill.vo.GoodsVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品表(Goods)表控制层
 *
 * @author xyh
 * @since 2022-06-30 16:47:37
 */

@RequestMapping("goods")
@Controller
public class GoodsController extends ApiController {


    /**
     * 服务对象
     */
    @Resource
    private GoodsService goodsService;

    @Resource
    private HttpServletRequest request;

    /**
     * 去商品详情页面
     *
     * @param id
     * @return
     */
    @GetMapping("/toDetail/{id}")
    public String goodsInfo(@PathVariable("id") Integer id) {
        // 根据id查询当前秒杀的商品
        GoodsVo goodsVo = goodsService.queryGoodsVoById(id);
        request.setAttribute("goods", goodsVo);
        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        Date nowDate = new Date();
        // 秒杀状态
        int secKillStatus = 0;
        // 秒杀时间
        int remainSeconds = 0;

        if (nowDate.before(startDate)) {
            remainSeconds = (int) ((startDate.getTime() - nowDate.getTime()) / 1000);
        } else if (nowDate.after(endDate)) {
            secKillStatus = 2;
            remainSeconds = 0;
        } else {
            secKillStatus = 1;
            remainSeconds = 0;
        }
        request.setAttribute("secKillStatus", secKillStatus);
        request.setAttribute("remainSeconds",remainSeconds);

        return "goodsDetail";
    }


    /**
     * 去商品页面
     *
     * @return
     */
    // 自定认证注解
    @Authentication()
    @RequestMapping("toList")
    public String toGoodsList() {
        // 获取秒杀商品 放入request中
        List<GoodsVo> goodsVos = goodsService.queryGoodsVo();
        request.setAttribute("goodsList", goodsVos);
        return "goodsList";
    }


    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param goods 查询实体
     * @return 所有数据
     */
    @GetMapping
    @ResponseBody
    public R selectAll(Page<Goods> page, Goods goods) {
        return success(this.goodsService.page(page, new QueryWrapper<>(goods)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ResponseBody
    public R selectOne(@PathVariable Serializable id) {
        return success(this.goodsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param goods 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ResponseBody
    public R insert(@RequestBody Goods goods) {
        return success(this.goodsService.save(goods));
    }

    /**
     * 修改数据
     *
     * @param goods 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ResponseBody
    public R update(@RequestBody Goods goods) {
        return success(this.goodsService.updateById(goods));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @ResponseBody
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.goodsService.removeByIds(idList));
    }
}

