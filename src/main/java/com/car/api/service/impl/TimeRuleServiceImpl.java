package com.car.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.car.api.dao.TimeRuleDao;
import com.car.api.dto.TimeRuleDTO;
import com.car.api.service.TimeRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 收费规则业务层实现类
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@Service("timeRuleService")
public class TimeRuleServiceImpl extends ServiceImpl<TimeRuleDao, TimeRuleDTO> implements TimeRuleService {

    @Override
    public Page<TimeRuleDTO> basePage(TimeRuleDTO timeRuleDTO) {
        if (null != timeRuleDTO.getCurrent() && null != timeRuleDTO.getPageSize())
            timeRuleDTO.setCurrent((timeRuleDTO.getCurrent() - 1) * timeRuleDTO.getPageSize());
        List<TimeRuleDTO> list = this.baseMapper.findList(timeRuleDTO);
        int count = this.baseMapper.findPageCount(timeRuleDTO);
        Page<TimeRuleDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<TimeRuleDTO> findList(TimeRuleDTO timeRuleDTO) {
        return this.baseMapper.findList(timeRuleDTO);
    }

}
