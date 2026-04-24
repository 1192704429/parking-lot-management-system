package com.car.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.car.api.dao.OrderInfoDao;
import com.car.api.dto.OrderInfoDTO;
import com.car.api.service.OrderInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 出入场记录业务层实现类
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@Service("orderInfoService")
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoDao, OrderInfoDTO> implements OrderInfoService {

    @Override
    public Page<OrderInfoDTO> basePage(OrderInfoDTO orderInfoDTO) {
        if (null != orderInfoDTO.getCurrent() && null != orderInfoDTO.getPageSize())
            orderInfoDTO.setCurrent((orderInfoDTO.getCurrent() - 1) * orderInfoDTO.getPageSize());
        List<OrderInfoDTO> list = this.baseMapper.findList(orderInfoDTO);
        int count = this.baseMapper.findPageCount(orderInfoDTO);
        Page<OrderInfoDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<OrderInfoDTO> findList(OrderInfoDTO orderInfoDTO) {
        return this.baseMapper.findList(orderInfoDTO);
    }

}
