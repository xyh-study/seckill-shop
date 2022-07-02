package com.njpi.xyh.seckill.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.njpi.xyh.seckill.entity.SeckillOrder;
import com.njpi.xyh.seckill.service.SeckillOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 秒杀订单表(SeckillOrder)表控制层
 *
 * @author xyh
 * @since 2022-06-30 16:47:41
 */
@RestController
@RequestMapping("seckillOrder")
public class SeckillOrderController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SeckillOrderService seckillOrderService;

    /**
     * 分页查询所有数据
     *
     * @param page         分页对象
     * @param seckillOrder 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SeckillOrder> page, SeckillOrder seckillOrder) {
        return success(this.seckillOrderService.page(page, new QueryWrapper<>(seckillOrder)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.seckillOrderService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param seckillOrder 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SeckillOrder seckillOrder) {
        return success(this.seckillOrderService.save(seckillOrder));
    }

    /**
     * 修改数据
     *
     * @param seckillOrder 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SeckillOrder seckillOrder) {
        return success(this.seckillOrderService.updateById(seckillOrder));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.seckillOrderService.removeByIds(idList));
    }
}

