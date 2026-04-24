package com.car.api.entity;

import com.car.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 出入场记录实体类
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderInfo extends BaseEntity {

    /**
    * 记录编号
    */
    private Long id;
    /**
    * 所属业主
    */
    private Long userId;
    /**
    * 车牌
    */
    private String carNumber;
    /**
    * 入场时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date inTime;
    /**
    * 出场时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date outTime;
    /**
    * 停车费
    */
    private Double money;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 停车时长
    */
    private Double hour;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
