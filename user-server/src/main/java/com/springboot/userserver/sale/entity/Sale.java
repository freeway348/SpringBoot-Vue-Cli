package com.springboot.userserver.sale.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author sdx2009
 * @since 2025-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sale")
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("salename")
    private String salename;

    @TableField("startdate")
    private String startdate;

    @TableField("enddate")
    private String enddate;

    @TableField("status")
    private String status;


}
