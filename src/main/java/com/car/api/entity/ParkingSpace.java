package com.car.api.entity;

import com.car.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 车位信息实体类
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ParkingSpace extends BaseEntity {

    /**
    * 序号
    */
    private Long id;
    /**
    * 车位编号
    */
    private String number;
    /**
    * 所处位置
    */
    private String address;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
