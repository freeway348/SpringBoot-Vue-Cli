package com.springboot.userserver.user.mapper;

import com.springboot.userserver.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sdx2009
 * @since 2025-06-23
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
