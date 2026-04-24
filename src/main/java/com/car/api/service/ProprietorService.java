package com.car.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.car.api.dto.ProprietorDTO;
import java.util.List;
/**
* @description: 业主信息业务层接口
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
public interface ProprietorService extends IService<ProprietorDTO> {

    /**
    * 默认分页方法
    * @param proprietorDTO
    * @return
    */
    Page<ProprietorDTO> basePage(ProprietorDTO proprietorDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param proprietorDTO
    * @return
    */
    List<ProprietorDTO> findList(ProprietorDTO proprietorDTO);

}
