package com.car.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.car.api.common.BaseController;
import com.car.api.common.ReturnMsg;
import com.car.api.dto.OrderInfoDTO;
import com.car.api.dto.TimeRuleDTO;
import com.car.api.service.OrderInfoService;
import com.car.api.service.TimeRuleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.car.api.common.BaseSelectEntity;

import java.time.Duration;
import java.time.Instant;
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
 * @description: 出入场记录对外接口层
 * @author: wuming
 * @create: 2025.03.12 14:47:49
 */
@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController extends BaseController<OrderInfoService, OrderInfoDTO> {

    @Autowired
    private ProprietorService proprietorService;

    @Autowired
    private TimeRuleService timeRuleService;

    @Override
    @Resource(name = "orderInfoService")
    protected void setBaseService(OrderInfoService orderInfoService) {
        this.baseService = orderInfoService;
    }

    /**
     * 默认分页查询
     *
     * @param orderInfoDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody OrderInfoDTO orderInfoDTO) {
        return ReturnMsg.ok(baseService.basePage(orderInfoDTO));
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param orderInfoDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody OrderInfoDTO orderInfoDTO) {
        return ReturnMsg.ok(baseService.findList(orderInfoDTO));
    }


    /**
     * 车辆出场
     *
     * @param orderInfoDTO
     * @return
     */
    @PostMapping(value = "/out")
    public ReturnMsg out(@RequestBody OrderInfoDTO orderInfoDTO) throws Exception {
        String carNumber = orderInfoDTO.getCarNumber();
        LambdaQueryWrapper<OrderInfoDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderInfoDTO::getCarNumber, carNumber).eq(OrderInfoDTO::getStatus, 0).orderByDesc(OrderInfoDTO::getCreateTime).last("limit 1");
        OrderInfoDTO baseServiceOne = this.baseService.getOne(queryWrapper);
        if (null == baseServiceOne) {
            throw new Exception("未查到车辆入场记录，出场失败！");
        }

        double difference = calculateHoursDifference(baseServiceOne.getInTime(), new Date());
        LambdaQueryWrapper<TimeRuleDTO> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.orderByAsc(TimeRuleDTO::getHour);
        List<TimeRuleDTO> ruleDTOS = timeRuleService.list(queryWrapper1);
        if (CollectionUtil.isEmpty(ruleDTOS)) {
            throw new Exception("尚未设置停车收费规则，请联系管理员处理！");
        }
        Double money = 0d;
        for (TimeRuleDTO ruleDTO : ruleDTOS) {
            Integer hour = ruleDTO.getHour();
            if (difference <= hour) {
                money = ruleDTO.getMoney();
                break;
            }
        }
        baseServiceOne.setOutTime(new Date());
        baseServiceOne.setHour(difference);
        baseServiceOne.setMoney(money);
        return ReturnMsg.ok(baseServiceOne);
    }

    public static double calculateHoursDifference(Date startDate, Date endDate) {
        // 将 Date 对象转换为 Instant 对象
        Instant startInstant = startDate.toInstant();
        Instant endInstant = endDate.toInstant();
        // 计算两个 Instant 对象之间的持续时间
        Duration duration = Duration.between(startInstant, endInstant);
        // 获取持续时间的总秒数
        long totalSeconds = duration.getSeconds();
        // 将总秒数转换为小时数
        double hours = (double) totalSeconds / 3600;
        // 保留一位小数
        return (double) Math.round(hours * 10) / 10;
    }

    @Override
    protected void beforeSave(OrderInfoDTO entity) throws Exception {
        String carNumber = entity.getCarNumber();
        LambdaQueryWrapper<OrderInfoDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderInfoDTO::getCarNumber, carNumber).eq(OrderInfoDTO::getStatus, 0);
        int count = this.baseService.count(queryWrapper);
        if (count > 0) {
            throw new Exception("车辆存在入场记录，尚未出场，不能重复进场！");
        }
        entity.setCreateTime(new Date());
        entity.setInTime(new Date());
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

