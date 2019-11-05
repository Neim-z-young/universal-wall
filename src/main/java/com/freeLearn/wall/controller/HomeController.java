package com.freeLearn.wall.controller;

import com.freeLearn.wall.common.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "HomeController", description = "主页内容")
@RestController
public class HomeController {

    @ApiOperation("获取主页")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public CommonResult homePage(){
        return CommonResult.success(null, "主页无内容");
    }
}
