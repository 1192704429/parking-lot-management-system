package com.car.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.car.api.dto.ParkingSpaceDTO;
import java.util.List;
/**
* @description: 车位信息业务层接口
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
public interface ParkingSpaceService extends IService<ParkingSpaceDTO> {

    /**
    * 默认分页方法
    * @param parkingSpaceDTO
    * @return
    */
    Page<ParkingSpaceDTO> basePage(ParkingSpaceDTO parkingSpaceDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param parkingSpaceDTO
    * @return
    */
    List<ParkingSpaceDTO> findList(ParkingSpaceDTO parkingSpaceDTO);

}
