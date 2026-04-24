package com.car.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.car.api.dto.SuggestDTO;
import java.util.List;
/**
* @description: 意见反馈业务层接口
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
public interface SuggestService extends IService<SuggestDTO> {

    /**
    * 默认分页方法
    * @param suggestDTO
    * @return
    */
    Page<SuggestDTO> basePage(SuggestDTO suggestDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param suggestDTO
    * @return
    */
    List<SuggestDTO> findList(SuggestDTO suggestDTO);

}
