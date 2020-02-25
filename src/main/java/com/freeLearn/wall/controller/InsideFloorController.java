package com.freeLearn.wall.controller;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.domain.InsideFloorDetails;
import com.freeLearn.wall.dto.InsideFloorParam;
import com.freeLearn.wall.mapper.InsideFloorMapper;
import com.freeLearn.wall.model.InsideFloor;
import com.freeLearn.wall.model.WallUser;
import com.freeLearn.wall.service.InsideFloorService;
import com.freeLearn.wall.service.WallUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "InsideFloorController", description = "评论回复控制器")
@RestController
@RequestMapping("/insideFloor")
public class InsideFloorController {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private InsideFloorService insideFloorService;

    @Autowired
    private WallUserService wallUserService;

    @ApiOperation("获取评论内的所有回复")
    @RequestMapping(value = "/allReply", method = RequestMethod.GET)
    CommonResult getAllReply(@RequestParam Integer floorId){
        List<InsideFloorDetails> detailsList = insideFloorService.getAllByFloorId(floorId);
        if(CollectionUtils.isEmpty(detailsList)){
            return CommonResult.failed("无回复");
        }
        return CommonResult.success(detailsList, "查询成功");
    }

    @ApiOperation("添加回复")
    @RequestMapping(value = "/addReply", method = RequestMethod.POST)
    CommonResult addReply(@Valid @RequestParam InsideFloorParam insideFloorParam, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            LOGGER.debug("参数验证错误：" + bindingResult);
        }
        WallUser user = wallUserService.getCurrentUser();
        if(user==null){
            return CommonResult.unauthorized("未登录");
        }
        return insideFloorService.addNewReply(user.getId(), insideFloorParam);
    }

    @ApiOperation("删除回复")
    @RequestMapping(value = "/deleteReply", method = RequestMethod.DELETE)
    CommonResult deleteReply(@RequestParam Integer insideFloorId){
        WallUser user = wallUserService.getCurrentUser();
        if(user==null){
            return CommonResult.unauthorized("未登录");
        }
        InsideFloor insideFloor = insideFloorService.getById(insideFloorId);
        if(insideFloor==null){
            return CommonResult.failed("回复不存在");
        }
        if(user.getId().equals(insideFloor.getId())){
            return insideFloorService.deleteById(insideFloorId);
        }
        return CommonResult.unauthorized("不是回复发起者");
    }
}
