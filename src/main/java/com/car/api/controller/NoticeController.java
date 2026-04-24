package com.car.api.controller;

import com.car.api.common.BaseController;
import com.car.api.common.ReturnMsg;
import com.car.api.dto.NoticeDTO;
import com.car.api.service.NoticeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.car.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 公告管理对外接口层
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@RestController
@RequestMapping("/notice")
public class NoticeController extends BaseController<NoticeService, NoticeDTO> {


    @Override
    @Resource(name = "noticeService")
    protected void setBaseService(NoticeService noticeService) {
        this.baseService = noticeService;
    }

    /**
    * 默认分页查询
    * @param noticeDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody NoticeDTO noticeDTO) {
        return ReturnMsg.ok(baseService.basePage(noticeDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param noticeDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody NoticeDTO noticeDTO) {
        return ReturnMsg.ok(baseService.findList(noticeDTO));
    }

    @Override
    protected void beforeSave(NoticeDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

