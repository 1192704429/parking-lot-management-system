package com.car.api.controller;

import com.car.api.common.BaseController;
import com.car.api.common.ReturnMsg;
import com.car.api.dto.ManageDTO;
import com.car.api.service.ManageService;
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
* @description: 物业人员对外接口层
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@RestController
@RequestMapping("/manage")
public class ManageController extends BaseController<ManageService, ManageDTO> {


    @Override
    @Resource(name = "manageService")
    protected void setBaseService(ManageService manageService) {
        this.baseService = manageService;
    }

    /**
    * 默认分页查询
    * @param manageDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody ManageDTO manageDTO) {
        return ReturnMsg.ok(baseService.basePage(manageDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param manageDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody ManageDTO manageDTO) {
        return ReturnMsg.ok(baseService.findList(manageDTO));
    }

    @Override
    protected void beforeSave(ManageDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

