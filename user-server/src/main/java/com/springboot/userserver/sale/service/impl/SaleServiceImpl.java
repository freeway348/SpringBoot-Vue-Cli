package com.springboot.userserver.sale.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.userserver.sale.dto.QuerySale;
import com.springboot.userserver.sale.entity.Sale;
import com.springboot.userserver.sale.mapper.SaleMapper;
import com.springboot.userserver.sale.service.SaleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.userserver.user.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sdx2009
 * @since 2025-06-27
 */
@Service
public class SaleServiceImpl extends ServiceImpl<SaleMapper, Sale> implements SaleService {

    @Override
    public Page<Sale> pageSale(QuerySale querySale) {
        // 1. 初始化分页对象Page，设置pageNumber和pageSize
        Page<Sale> p = new Page<>(querySale.getPageNumber(), querySale.getPageSize());

        // 2. 判断筛选条件是否为空，不为空则给条件构造器，构造筛选条件
        QueryWrapper<Sale> w = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(querySale.getSalename())) {
            // 相当于sql: where salename like '% ? %'
            w.like("salename", querySale.getSalename());
        }

        // 3. 调用mybatis-plus提供的page方法进行分页查询，返回查询结果
        Page<Sale> result = this.page(p, w);

        return result;

    }

}
