package com.car.api.controller;

import com.car.api.common.BaseController;
import com.car.api.common.ReturnMsg;
import com.car.api.dto.ProprietorDTO;
import com.car.api.service.ProprietorService;
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
* @description: 业主信息对外接口层
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@RestController
@RequestMapping("/proprietor")
public class ProprietorController extends BaseController<ProprietorService, ProprietorDTO> {


    @Override
    @Resource(name = "proprietorService")
    protected void setBaseService(ProprietorService proprietorService) {
        this.baseService = proprietorService;
    }

    /**
    * 默认分页查询
    * @param proprietorDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody ProprietorDTO proprietorDTO) {
        return ReturnMsg.ok(baseService.basePage(proprietorDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param proprietorDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody ProprietorDTO proprietorDTO) {
        return ReturnMsg.ok(baseService.findList(proprietorDTO));
    }

    @Override
    protected void beforeSave(ProprietorDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

