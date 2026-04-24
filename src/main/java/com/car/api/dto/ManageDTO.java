package com.car.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.car.api.entity. Manage;
import lombok.Data;
import lombok.ToString;

/**
* @description: 物业人员数据传输层
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@Data
@ToString
@TableName("manage")
public class ManageDTO extends Manage {


}
