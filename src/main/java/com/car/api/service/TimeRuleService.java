package com.car.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.car.api.dto.TimeRuleDTO;
import java.util.List;
/**
* @description: 收费规则业务层接口
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
public interface TimeRuleService extends IService<TimeRuleDTO> {

    /**
    * 默认分页方法
    * @param timeRuleDTO
    * @return
    */
    Page<TimeRuleDTO> basePage(TimeRuleDTO timeRuleDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param timeRuleDTO
    * @return
    */
    List<TimeRuleDTO> findList(TimeRuleDTO timeRuleDTO);

}
