package com.car.api.controller;

import com.car.api.common.BaseController;
import com.car.api.common.ReturnMsg;
import com.car.api.dto.CarInfoDTO;
import com.car.api.service.CarInfoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.car.api.common.BaseSelectEntity;
import java.util.ArrayList;
import com.car.api.service.ProprietorService;
import com.car.api.dto.ProprietorDTO;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.car.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 车辆信息对外接口层
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@RestController
@RequestMapping("/carInfo")
public class CarInfoController extends BaseController<CarInfoService, CarInfoDTO> {

    @Autowired
    private ProprietorService proprietorService;

    @Override
    @Resource(name = "carInfoService")
    protected void setBaseService(CarInfoService carInfoService) {
        this.baseService = carInfoService;
    }

    /**
    * 默认分页查询
    * @param carInfoDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody CarInfoDTO carInfoDTO) {
        return ReturnMsg.ok(baseService.basePage(carInfoDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param carInfoDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody CarInfoDTO carInfoDTO) {
        return ReturnMsg.ok(baseService.findList(carInfoDTO));
    }

    @Override
    protected void beforeSave(CarInfoDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    @GetMapping("/all/proprietor")
    public ReturnMsg allProprietor() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<ProprietorDTO> dtos = proprietorService.list();
            for (ProprietorDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

}

