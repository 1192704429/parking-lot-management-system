package com.car.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.car.api.dto.OrderInfoDTO;
import java.util.List;
/**
* @description: 出入场记录业务层接口
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
public interface OrderInfoService extends IService<OrderInfoDTO> {

    /**
    * 默认分页方法
    * @param orderInfoDTO
    * @return
    */
    Page<OrderInfoDTO> basePage(OrderInfoDTO orderInfoDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param orderInfoDTO
    * @return
    */
    List<OrderInfoDTO> findList(OrderInfoDTO orderInfoDTO);

}
