package com.car.api.controller;

import com.car.api.common.BaseController;
import com.car.api.common.ReturnMsg;
import com.car.api.dto.ParkingSpaceDTO;
import com.car.api.service.ParkingSpaceService;
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
* @description: 车位信息对外接口层
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@RestController
@RequestMapping("/parkingSpace")
public class ParkingSpaceController extends BaseController<ParkingSpaceService, ParkingSpaceDTO> {


    @Override
    @Resource(name = "parkingSpaceService")
    protected void setBaseService(ParkingSpaceService parkingSpaceService) {
        this.baseService = parkingSpaceService;
    }

    /**
    * 默认分页查询
    * @param parkingSpaceDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody ParkingSpaceDTO parkingSpaceDTO) {
        return ReturnMsg.ok(baseService.basePage(parkingSpaceDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param parkingSpaceDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody ParkingSpaceDTO parkingSpaceDTO) {
        return ReturnMsg.ok(baseService.findList(parkingSpaceDTO));
    }

    @Override
    protected void beforeSave(ParkingSpaceDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

