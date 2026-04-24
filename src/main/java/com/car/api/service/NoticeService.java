package com.car.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.car.api.dto.NoticeDTO;
import java.util.List;
/**
* @description: 公告管理业务层接口
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
public interface NoticeService extends IService<NoticeDTO> {

    /**
    * 默认分页方法
    * @param noticeDTO
    * @return
    */
    Page<NoticeDTO> basePage(NoticeDTO noticeDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param noticeDTO
    * @return
    */
    List<NoticeDTO> findList(NoticeDTO noticeDTO);

}
