package com.springboot.userserver.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.userserver.user.dto.LoginUser;
import com.springboot.userserver.user.dto.QueryUser;
import com.springboot.userserver.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 *  接口默认所有方法声明都是public
 * </p>
 *
 * @author sdx2009
 * @since 2025-06-23
 */
public interface UserService extends IService<User> {

    // 接口只能做方法的声明

    // 登录
    boolean loginUser(LoginUser loginUser);

    // 用户分页查询
    Page<User> pageUser(QueryUser queryUser);
}
