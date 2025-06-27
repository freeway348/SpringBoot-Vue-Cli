package com.springboot.userserver.sale.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.userserver.sale.dto.QuerySale;
import com.springboot.userserver.sale.entity.Sale;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.userserver.user.dto.LoginUser;
import com.springboot.userserver.user.dto.QueryUser;
import com.springboot.userserver.user.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sdx2009
 * @since 2025-06-27
 */
public interface SaleService extends IService<Sale> {

    // 用户分页查询
    Page<Sale> pageSale(QuerySale querySale); // (查询按钮点击事件)


}
