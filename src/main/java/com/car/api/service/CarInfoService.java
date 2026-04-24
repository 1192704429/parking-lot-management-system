package com.car.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.car.api.dto.CarInfoDTO;
import java.util.List;
/**
* @description: 车辆信息业务层接口
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
public interface CarInfoService extends IService<CarInfoDTO> {

    /**
    * 默认分页方法
    * @param carInfoDTO
    * @return
    */
    Page<CarInfoDTO> basePage(CarInfoDTO carInfoDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param carInfoDTO
    * @return
    */
    List<CarInfoDTO> findList(CarInfoDTO carInfoDTO);

}
