package com.car.api.entity;

import com.car.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 车辆信息实体类
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarInfo extends BaseEntity {

    /**
    * 车辆编号
    */
    private Long id;
    /**
    * 车辆图片
    */
    private String carImg;
    /**
    * 所属业主
    */
    private Long userId;
    /**
    * 车牌
    */
    private String carNumber;
    /**
    * 车辆型号
    */
    private String vehicle;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
