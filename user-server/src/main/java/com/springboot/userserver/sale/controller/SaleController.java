package com.springboot.userserver.sale.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.userserver.sale.dto.QuerySale;
import com.springboot.userserver.sale.entity.Sale;
import com.springboot.userserver.sale.service.SaleService;
import com.springboot.userserver.user.dto.LoginUser;
import com.springboot.userserver.user.dto.QueryUser;
import com.springboot.userserver.user.entity.User;
import com.springboot.userserver.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sdx2009
 * @since 2025-06-27
 */
@RestController
@RequestMapping("/sale")
public class SaleController {
    @Resource // 做依赖注入，从SpringbootIOC容器中取对象
    private SaleService saleService; // 取的对象及对应的变量即为该行


    @GetMapping("/page")
    public JSONObject page(QuerySale querySale){

        // 1. 将请求参数转发给service处理
        Page<Sale> result = saleService.pageSale(querySale);

        // 2. 获取处理结果，返回给前端
        // 如果获取值result为空，则返回给前端也没有影响，不会出现页面为空的情况
        JSONObject obj = new JSONObject();
        obj.put("code", 200);
        obj.put("rows", result.getRecords()); // Records存储的是查询到的数据链表；而getTotal()存储的是查询到的数据总数
        obj.put("total", result.getTotal());


        return obj;
    }

    @PostMapping("/add")
    public JSONObject add(@RequestBody Sale sale){ // 原本是不允许使用/entity下的实体类对象的（不符合开发规范），因为实体类一般不修改其字段，但前端传过来的数据不一定与该实体类的对象一致，所以可能更改实体类（但这样做会导致实体类无法与数据库中数据进行配对），所以一般不使用实体类

        boolean result = saleService.save(sale); // 使用mybatis-plus中的save方法，将前端传入的数据存到数据表中，并返回结果（是否成功）


        JSONObject obj = new JSONObject();

        if (result){ // 保存数据成功
            obj.put("code", 200);
            obj.put("msg", "添加用户成功");
        }else {
            obj.put("code", 500);
            obj.put("msg", "添加用户失败");
        }
        return obj;
    }

    @PostMapping("/update")
    public JSONObject update(@RequestBody Sale sale){
        boolean result = saleService.updateById(sale); // mybatis-plus的方法，在单表中mybatis-plus比mybatis方便，但在多表中这俩差不多
        // 使用预加载，将数据预先存储到redis中，比用mysql语句查询的实时性会更好，适合在实时性要求高时使用
        JSONObject obj = new JSONObject();
        if (result){
            obj.put("code", 200);
            obj.put("msg", "修改用户成功");
        }else {
            obj.put("code", 500);
            obj.put("msg", "修改用户失败");
        }

        return obj;
    }

    @DeleteMapping("/delete") // 前端调用axios.delete需要改Mapping导向路径
    public JSONObject delete(Integer id){

        boolean result = saleService.removeById(id);

        // 如果给多张表进行操作，则需要添加事务，否则可能会出现数据不一致的情况（可能一张表成功，另一张表却失败，此时需要回滚，否则无法完成任务）

        JSONObject obj = new JSONObject();

        if (result){
            obj.put("code", 200);
            obj.put("msg", "删除用户成功");
        }else {
            obj.put("code", 500);
            obj.put("msg", "删除用户失败");
        }

        return obj;
    }

    @GetMapping("/dashboard/stats")
    public JSONObject getSaleStats() {
        // 从数据库获取所有用户信息
        List<Sale> saleList = saleService.list();
        JSONObject stats = new JSONObject();

        // 初始化统计变量
        int nstCount = 0;
        int ingCount = 0;
        int endCount = 0;

        // 遍历用户数据进行统计
        for (Sale sale : saleList) {
            String role = sale.getStatus();
            if ("未开始".equals(role)) {
                nstCount++;
            } else if ("进行中".equals(role)) {
                ingCount++;
            } else {
                endCount++;
            }

        }

        // 将统计结果放入 JSON 对象
        stats.put("nstCount", nstCount);
        stats.put("ingCount", ingCount);
        stats.put("endCount", endCount);
        return stats;
    }
}
