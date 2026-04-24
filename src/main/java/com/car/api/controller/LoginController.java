package com.car.api.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.car.api.common.ReturnMsg;
import com.car.api.dto.ManageDTO;
import com.car.api.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 后台管理登录控制器
 * @author: wuming
 * @Create: 2025.03.12 14:47:49
 */
@RestController
@RequestMapping("/manage/login")
public class LoginController {

    static Map<String, String> userInfoMap = new HashMap<>();

    @Autowired
    private ManageService manageService;

    @PostMapping
    public ReturnMsg manageLogin(@RequestBody Map<String, String> param) {
        if (StrUtil.isEmpty(param.get("username")) || StrUtil.isEmpty(param.get("password"))) {
            return ReturnMsg.error("用户名或密码错误!");
        }
        ManageDTO manageDTO = new ManageDTO();
        manageDTO.setUsername(param.get("username"));
        manageDTO.setPassword(param.get("password"));
        QueryWrapper<ManageDTO> manageDTOQueryWrapper = new QueryWrapper<>(manageDTO);
        manageDTOQueryWrapper.last("limit 1");
        ManageDTO adminDTOS = manageService.getOne(manageDTOQueryWrapper);
        if (adminDTOS == null) return ReturnMsg.error("用户名或密码错误!");
        Map<String, Object> map = new HashMap<>();
        map.put("avatar", StrUtil.isNotBlank(adminDTOS.getHeadImg()) ? adminDTOS.getHeadImg() : "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("introduction", adminDTOS.getNickname() + ",你好!");
        map.put("name", adminDTOS.getNickname());
        map.put("id", adminDTOS.getId());
        map.put("roles", adminDTOS.getRole());
        Map<String, String> returnMap = new HashMap<>();
        String uuid = UUID.randomUUID().toString();
        returnMap.put("token", uuid);
        userInfoMap.put(uuid, JSON.toJSONString(map));
        return ReturnMsg.ok(returnMap);
    }

    @GetMapping
    public ReturnMsg getUserInfo(@RequestParam("token") String token) {
        if (!userInfoMap.containsKey(token)) return ReturnMsg.error(401,"尚未登录,请重新登录!");
        return ReturnMsg.ok(JSON.parse(userInfoMap.get(token)));
    }

    @GetMapping("/logout")
    public ReturnMsg logout(@RequestParam("token") String token) {
        userInfoMap.remove(token);
        return ReturnMsg.ok();
    }

}
