package com.car.api.entity;

import com.car.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 业主信息实体类
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Proprietor extends BaseEntity {

    /**
    * 业主编号
    */
    private Long id;
    /**
    * 业主姓名
    */
    private String name;
    /**
    * 联系方式
    */
    private String tel;
    /**
    * 住户信息
    */
    private String houseInfo;
    /**
    * 车牌
    */
    private String carNumber;
    /**
    * 头像
    */
    private String avatar;
    /**
    * 用户名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
