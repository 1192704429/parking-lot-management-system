package com.car.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.car.api.entity. Suggest;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @description: 意见反馈数据传输层
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@Data
@ToString
@TableName("suggest")
public class SuggestDTO extends Suggest {

    /**
    * 业主姓名
    */
    @TableField(exist = false)
    private String name;

}
