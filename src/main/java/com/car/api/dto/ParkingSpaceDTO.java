package com.car.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.car.api.entity. ParkingSpace;
import lombok.Data;
import lombok.ToString;

/**
* @description: 车位信息数据传输层
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@Data
@ToString
@TableName("parking_space")
public class ParkingSpaceDTO extends ParkingSpace {


}
