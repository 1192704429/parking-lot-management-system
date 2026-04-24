package com.car.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.car.api.dto.ManageDTO;
import java.util.List;
/**
* @description: 物业人员业务层接口
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
public interface ManageService extends IService<ManageDTO> {

    /**
    * 默认分页方法
    * @param manageDTO
    * @return
    */
    Page<ManageDTO> basePage(ManageDTO manageDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param manageDTO
    * @return
    */
    List<ManageDTO> findList(ManageDTO manageDTO);

}
