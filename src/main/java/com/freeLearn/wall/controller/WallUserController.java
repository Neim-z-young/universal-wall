package com.freeLearn.wall.controller;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.dto.WallUserLoginParam;
import com.freeLearn.wall.dto.WallUserParam;
import com.freeLearn.wall.service.WallUserService;
import com.freeLearn.wall.util.WeChatUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "WallUserController", description = "用户管理")
@RestController
@RequestMapping("/user")
public class WallUserController {
    private static final Logger LOGGER = LogManager.getLogger();

    //TODO
    @Autowired
    private WallUserService wallUserService;

    @Autowired
    private WeChatUtil weChatUtil;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation("微信code登录")
    @RequestMapping(value = "/weChat/login", method = RequestMethod.POST)
    public CommonResult weChatLogin(@RequestBody String code){
        //String openId = weChatUtil.generateOpenId(code);
        WeChatUtil.ResObject resObject = weChatUtil.generateResObject(code);
        if(resObject.getOpenid()==null){
            //请求得到openId失败，返回错误对象
            return CommonResult.unauthorized(resObject);
        }
        String token =  wallUserService.loginWeChat(resObject.getOpenid());
        if(token==null){
            return CommonResult.validateFailed("认证失败");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult register(@Valid @RequestBody WallUserParam wallUserParam, BindingResult bindingResult){
        //通过前端校验参数异常
        if(bindingResult.hasErrors()){
            LOGGER.debug("参数验证错误");
        }
        return wallUserService.register(wallUserParam);
    }

    @ApiOperation("用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@Valid @RequestBody WallUserLoginParam loginParam, BindingResult bindingResult){
        //通过前端校验参数异常
        if(bindingResult.hasErrors()){
            LOGGER.debug("参数验证错误");
        }
        String token = wallUserService.login(loginParam.getUsername(), loginParam.getPassword());
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
