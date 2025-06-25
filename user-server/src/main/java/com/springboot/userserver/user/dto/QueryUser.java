package com.springboot.userserver.user.dto;

import lombok.Data;

@Data
public class QueryUser {
    // 必须的参数
    private long pageNumber;
    private long pageSize;

    // 筛选条件，可选
    private String username;
}
