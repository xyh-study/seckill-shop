package com.njpi.xyh.seckill.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.njpi.xyh.seckill.entity.SeckillGoods;
import com.njpi.xyh.seckill.service.SeckillGoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 秒杀商品表(SeckillGoods)表控制层
 *
 * @author xyh
 * @since 2022-06-30 16:47:41
 */
@RestController
@RequestMapping("seckillGoods")
public class SeckillGoodsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SeckillGoodsService seckillGoodsService;

    /**
     * 分页查询所有数据
     *
     * @param page         分页对象
     * @param seckillGoods 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SeckillGoods> page, SeckillGoods seckillGoods) {
        return success(this.seckillGoodsService.page(page, new QueryWrapper<>(seckillGoods)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.seckillGoodsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param seckillGoods 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SeckillGoods seckillGoods) {
        return success(this.seckillGoodsService.save(seckillGoods));
    }

    /**
     * 修改数据
     *
     * @param seckillGoods 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SeckillGoods seckillGoods) {
        return success(this.seckillGoodsService.updateById(seckillGoods));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.seckillGoodsService.removeByIds(idList));
    }
}

