package com.car.api.entity;

import com.car.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 意见反馈实体类
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Suggest extends BaseEntity {

    /**
    * 反馈编号
    */
    private Long id;
    /**
    * 反馈用户
    */
    private Long userId;
    /**
    * 反馈内容
    */
    private String content;
    /**
    * 物业回复
    */
    private String answer;
    /**
    * 处理状态
    */
    private Integer status;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 标题
    */
    private String title;


}
