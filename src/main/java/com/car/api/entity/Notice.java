package com.car.api.entity;

import com.car.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 公告管理实体类
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notice extends BaseEntity {

    /**
    * 公告编号
    */
    private Long id;
    /**
    * 标题
    */
    private String title;
    /**
    * 封面图片
    */
    private String noticeImg;
    /**
    * 内容
    */
    private String content;
    /**
    * 简介
    */
    private String info;
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
