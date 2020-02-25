package com.freeLearn.wall.controller;

import com.freeLearn.wall.common.CommonPage;
import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.domain.FloorBrief;
import com.freeLearn.wall.domain.FloorDetails;
import com.freeLearn.wall.dto.FloorParam;
import com.freeLearn.wall.model.Floor;
import com.freeLearn.wall.model.WallUser;
import com.freeLearn.wall.service.FloorService;
import com.freeLearn.wall.service.WallUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "FloorController", description = "评论控制器")
@RestController
@RequestMapping("/floor")
public class FloorController {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private FloorService floorService;

    @Autowired
    private WallUserService wallUserService;


    @ApiOperation("根据帖子id获取评论列表")
    @RequestMapping(value = "/pageNumListFloorsByPostingId", method = RequestMethod.GET)
    CommonResult getPageNumListFloorsByPostingId(@RequestParam Integer postingId,
                                                 @RequestParam(defaultValue = "1") Integer pageNum,
                                                 @RequestParam(defaultValue = "10") Integer pageSize){
        List<FloorBrief> floorBriefList = floorService.listPageNumByPostingId(postingId, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(floorBriefList), "评论查询成功");
    }

    @ApiOperation("发布评论")
    @RequestMapping(value = "/makeComment", method = RequestMethod.POST)
    CommonResult makeComment(@Valid @RequestBody FloorParam floorParam, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            LOGGER.debug("参数验证错误：" + bindingResult);
        }
        WallUser user = wallUserService.getCurrentUser();
        if(user==null){
            return CommonResult.unauthorized("未登录");
        }
        return floorService.addNewComment(user.getId(), floorParam);
    }

    @ApiOperation("删除评论")
    @RequestMapping(value = "/deleteComment", method = RequestMethod.DELETE)
    CommonResult deleteComment(@RequestParam Integer floorId){
        WallUser user = wallUserService.getCurrentUser();
        if(user==null){
            return CommonResult.unauthorized("未登录");
        }
        Floor floor = floorService.getById(floorId);
        if(floor==null){
            return CommonResult.failed("评论不存在");
        }
        if(floor.getId().equals(user.getId())){
            return floorService.deleteById(floorId);
        }
        return CommonResult.unauthorized("不是评论发起者");
    }

    @ApiOperation("按页显示评论回复")
    @RequestMapping(value = "/pageNumListInsideFloorsByFloorId", method = RequestMethod.DELETE)
    CommonResult getPageNumListInsideFloorsByFloorId(@RequestParam Integer floorId,
                                                     @RequestParam(defaultValue = "1") Integer pageNum,
                                                     @RequestParam(defaultValue = "10") Integer pageSize){
        FloorDetails floorDetails = floorService.listPageNumReply(floorId, pageNum, pageSize);
        return CommonResult.success(floorDetails, "评论内容查询成功");
    }
}
