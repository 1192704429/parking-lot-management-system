package com.car.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.car.api.dao.CarInfoDao;
import com.car.api.dto.CarInfoDTO;
import com.car.api.service.CarInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 车辆信息业务层实现类
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@Service("carInfoService")
public class CarInfoServiceImpl extends ServiceImpl<CarInfoDao, CarInfoDTO> implements CarInfoService {

    @Override
    public Page<CarInfoDTO> basePage(CarInfoDTO carInfoDTO) {
        if (null != carInfoDTO.getCurrent() && null != carInfoDTO.getPageSize())
            carInfoDTO.setCurrent((carInfoDTO.getCurrent() - 1) * carInfoDTO.getPageSize());
        List<CarInfoDTO> list = this.baseMapper.findList(carInfoDTO);
        int count = this.baseMapper.findPageCount(carInfoDTO);
        Page<CarInfoDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<CarInfoDTO> findList(CarInfoDTO carInfoDTO) {
        return this.baseMapper.findList(carInfoDTO);
    }

}
