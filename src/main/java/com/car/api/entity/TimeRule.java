package com.car.api.entity;

import com.car.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 收费规则实体类
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TimeRule extends BaseEntity {

    /**
    * 收费规则编号
    */
    private Long id;
    /**
    * 时长
    */
    private Integer hour;
    /**
    * 收费金额
    */
    private Double money;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
