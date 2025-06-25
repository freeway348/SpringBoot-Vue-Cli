package com.springboot.userserver.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.userserver.user.dto.LoginUser;
import com.springboot.userserver.user.dto.QueryUser;
import com.springboot.userserver.user.entity.User;
import com.springboot.userserver.user.mapper.UserMapper;
import com.springboot.userserver.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sdx2009
 * @since 2025-06-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean loginUser(LoginUser loginUser) {
        // 1. 把username和password构造成sql的筛选条件
        // sql：select * from user where username = ? and password = ?

        // 单表查询使用mybatis-plus提供的条件构造器，该构造器只适用于单表查询
        QueryWrapper<User> w = new QueryWrapper<>();
        // 第一个参数填写的不是User对象的属性名，而是数据库数据表中的字段名
        w.eq("username", loginUser.getUsername());
        // eq相当于sql:username = ?
        w.eq("password", loginUser.getPassword());
        // eq相当于sql：password = ?
        // 如果构造器连续调用方法，则方法之间默认以and连接，构成的完整sql语句就是：username = ? and password = ?
        // 如果要做or关系，则需要显式调用or方法


        // 2. 把sql语句提交给mysql，获取结果
        User user = this.getOne(w);

        // 3. 将结果返回给controller
        if (!ObjectUtils.isEmpty(user)) // 如果非空
            return true;

        return false;
    }

    @Override
    public Page<User> pageUser(QueryUser queryUser) {
        // 1. 初始化分页对象Page，设置pageNumber和pageSize
        Page<User> p = new Page<>(queryUser.getPageNumber(), queryUser.getPageSize());

        // 2. 判断筛选条件是否为空，不为空则给条件构造器，构造筛选条件
        QueryWrapper<User> w = new QueryWrapper<>();
        if(!ObjectUtils.isEmpty(queryUser.getUsername())){
            // 相当于sql: where username like '% ? %'
            w.like("username", queryUser.getUsername());
        }

        // 3. 调用mybatis-plus提供的page方法进行分页查询，返回查询结果
        Page<User> result = this.page(p, w);

        return result;
    }
}
