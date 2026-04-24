package com.car.api.controller;

import com.car.api.common.BaseController;
import com.car.api.common.ReturnMsg;
import com.car.api.dto.TimeRuleDTO;
import com.car.api.service.TimeRuleService;
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
* @description: 收费规则对外接口层
* @author: wuming
* @create: 2025.03.12 14:47:49
*/
@RestController
@RequestMapping("/timeRule")
public class TimeRuleController extends BaseController<TimeRuleService, TimeRuleDTO> {


    @Override
    @Resource(name = "timeRuleService")
    protected void setBaseService(TimeRuleService timeRuleService) {
        this.baseService = timeRuleService;
    }

    /**
    * 默认分页查询
    * @param timeRuleDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody TimeRuleDTO timeRuleDTO) {
        return ReturnMsg.ok(baseService.basePage(timeRuleDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param timeRuleDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody TimeRuleDTO timeRuleDTO) {
        return ReturnMsg.ok(baseService.findList(timeRuleDTO));
    }

    @Override
    protected void beforeSave(TimeRuleDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

