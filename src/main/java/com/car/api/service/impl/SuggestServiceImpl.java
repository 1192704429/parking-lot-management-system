package com.car.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.car.api.dao.SuggestDao;
import com.car.api.dto.SuggestDTO;
import com.car.api.service.SuggestService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 意见反馈业务层实现类
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@Service("suggestService")
public class SuggestServiceImpl extends ServiceImpl<SuggestDao, SuggestDTO> implements SuggestService {

    @Override
    public Page<SuggestDTO> basePage(SuggestDTO suggestDTO) {
        if (null != suggestDTO.getCurrent() && null != suggestDTO.getPageSize())
            suggestDTO.setCurrent((suggestDTO.getCurrent() - 1) * suggestDTO.getPageSize());
        List<SuggestDTO> list = this.baseMapper.findList(suggestDTO);
        int count = this.baseMapper.findPageCount(suggestDTO);
        Page<SuggestDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<SuggestDTO> findList(SuggestDTO suggestDTO) {
        return this.baseMapper.findList(suggestDTO);
    }

}
