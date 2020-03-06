package com.freeLearn.wall.controller;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.domain.WallUserDetailedInformation;
import com.freeLearn.wall.service.WallUserInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "UserInformationController", description = "用户信息")
@RestController
@RequestMapping("/userInformation")
public class UserInformationController {
    @Autowired
    private WallUserInformationService wallUserInformationService;

    @ApiOperation("获取用户信息")
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    CommonResult getUserInfo(Integer userId){
        WallUserDetailedInformation detailedInformation = wallUserInformationService.getDetailedById(userId);
        if(detailedInformation==null){
            return CommonResult.notFound("用户不存在");
        }
        return CommonResult.success(detailedInformation, "查询成功");
    }

}
