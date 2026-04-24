package com.car.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.car.api.dao.ParkingSpaceDao;
import com.car.api.dto.ParkingSpaceDTO;
import com.car.api.service.ParkingSpaceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 车位信息业务层实现类
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@Service("parkingSpaceService")
public class ParkingSpaceServiceImpl extends ServiceImpl<ParkingSpaceDao, ParkingSpaceDTO> implements ParkingSpaceService {

    @Override
    public Page<ParkingSpaceDTO> basePage(ParkingSpaceDTO parkingSpaceDTO) {
        if (null != parkingSpaceDTO.getCurrent() && null != parkingSpaceDTO.getPageSize())
            parkingSpaceDTO.setCurrent((parkingSpaceDTO.getCurrent() - 1) * parkingSpaceDTO.getPageSize());
        List<ParkingSpaceDTO> list = this.baseMapper.findList(parkingSpaceDTO);
        int count = this.baseMapper.findPageCount(parkingSpaceDTO);
        Page<ParkingSpaceDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<ParkingSpaceDTO> findList(ParkingSpaceDTO parkingSpaceDTO) {
        return this.baseMapper.findList(parkingSpaceDTO);
    }

}
