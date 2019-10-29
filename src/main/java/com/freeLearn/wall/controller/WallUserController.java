package com.freeLearn.wall.controller;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.dto.WallUserParam;
import com.freeLearn.wall.service.WallUserService;
import com.freeLearn.wall.util.WeChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class WallUserController {

    //TODO
    @Autowired
    private WallUserService wallUserService;

    @Autowired
    private WeChatUtil weChatUtil;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @RequestMapping(value = "/weChat/login", method = RequestMethod.POST)
    public CommonResult weChatLogin(@RequestParam String code){
        String openId = weChatUtil.generateOpenId(code);
        String token =  wallUserService.loginWeChat(openId);
        if(token==null){
            return CommonResult.validateFailed("认证过期");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult register(@RequestParam WallUserParam wallUserParam){
        return wallUserService.register(wallUserParam);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@RequestParam String username,
                              @RequestParam String password){
        String token = wallUserService.login(username, password);
        if(token==null){
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);

    }
//
//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public CommonResult logout(){
//
//    }
}
