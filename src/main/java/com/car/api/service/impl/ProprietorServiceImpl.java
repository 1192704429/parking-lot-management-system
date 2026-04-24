package com.car.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.car.api.dao.ProprietorDao;
import com.car.api.dto.ProprietorDTO;
import com.car.api.service.ProprietorService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 业主信息业务层实现类
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@Service("proprietorService")
public class ProprietorServiceImpl extends ServiceImpl<ProprietorDao, ProprietorDTO> implements ProprietorService {

    @Override
    public Page<ProprietorDTO> basePage(ProprietorDTO proprietorDTO) {
        if (null != proprietorDTO.getCurrent() && null != proprietorDTO.getPageSize())
            proprietorDTO.setCurrent((proprietorDTO.getCurrent() - 1) * proprietorDTO.getPageSize());
        List<ProprietorDTO> list = this.baseMapper.findList(proprietorDTO);
        int count = this.baseMapper.findPageCount(proprietorDTO);
        Page<ProprietorDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<ProprietorDTO> findList(ProprietorDTO proprietorDTO) {
        return this.baseMapper.findList(proprietorDTO);
    }

}
