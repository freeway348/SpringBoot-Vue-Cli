package com.springboot.userserver.sale.dto;

import lombok.Data;

@Data
public class QuerySale {
    // 必须的参数
    private long pageNumber;
    private long pageSize;

    // 筛选条件，可选
    private String salename; // 查询框所查询的数据

}
