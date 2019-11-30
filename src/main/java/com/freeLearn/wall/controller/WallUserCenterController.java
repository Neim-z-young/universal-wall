package com.freeLearn.wall.controller;

import com.freeLearn.wall.common.CommonPage;
import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.domain.PostingBrief;
import com.freeLearn.wall.dto.PostingParam;
import com.freeLearn.wall.model.Posting;
import com.freeLearn.wall.model.WallUser;
import com.freeLearn.wall.service.PostingService;
import com.freeLearn.wall.service.WallUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "WallUserCenterController", description = "用户中心")
@RestController
@RequestMapping("/userCenter")
public class WallUserCenterController {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private PostingService postingService;
    @Autowired
    private WallUserService wallUserService;

    @ApiOperation("获取登录用户发布的帖子")
    @RequestMapping(value = "/posting", method = RequestMethod.GET)
    CommonResult releasedPostings(@RequestParam(defaultValue = "1") Integer pageNum,
                                  @RequestParam(defaultValue = "10") Integer pageSize){
        WallUser user = wallUserService.getCurrentUser();
        if(user==null){
            return CommonResult.unauthorized("未登录");
        }
        List<PostingBrief> postingBriefList = postingService.listPageByPosterId(user.getId(), pageNum, pageSize);
        if(CollectionUtils.isEmpty(postingBriefList)){
            return CommonResult.notFound("未发布任何帖子");
        }
        return CommonResult.success(CommonPage.restPage(postingBriefList));
    }

    @ApiOperation("删除帖子")
    @RequestMapping(value = "/posting", method = RequestMethod.DELETE)
    CommonResult deletePosting(@RequestParam Integer postingId){
        WallUser user = wallUserService.getCurrentUser();
        if(user==null){
            return CommonResult.unauthorized("未登录");
        }
        Posting posting = postingService.getById(postingId);
        if(posting==null){
            return CommonResult.notFound("并无此帖子");
        }
        if(!posting.getPosterId().equals(user.getId())){
            return CommonResult.unauthorized("不是帖子的所有者");
        }
        return postingService.deletePosting(posting.getId());

    }

    @ApiOperation("修改帖子")
    @RequestMapping(value = "/posting", method = RequestMethod.PUT)
    CommonResult modifyPosting(@RequestParam Integer postingId,
                               @RequestParam String detailedIntroduction,
                               @RequestParam String pictureIntroduction){
        WallUser user = wallUserService.getCurrentUser();
        if(user==null){
            return CommonResult.unauthorized("未登录");
        }
        Posting posting = postingService.getById(postingId);
        if(posting==null){
            return CommonResult.notFound("并无此帖子");
        }
        if(!posting.getPosterId().equals(user.getId())){
            return CommonResult.unauthorized("不是帖子的所有者");
        }
        return postingService.updatePosting(posting.getId(), detailedIntroduction, pictureIntroduction);
    }

    @ApiOperation("发布帖子")
    @RequestMapping(value = "/posting", method = RequestMethod.POST)
    CommonResult release(@Valid @RequestBody PostingParam postingParam, BindingResult bindingResult){
        //通过前端校验参数异常
        if(bindingResult.hasErrors()){
            LOGGER.debug("参数验证错误：" + bindingResult);
        }
        WallUser user = wallUserService.getCurrentUser();
        if(user==null){
            return CommonResult.unauthorized("未登录");
        }
        return postingService.addNewPosting(user.getId(), postingParam);
    }

    @ApiOperation("获取消息列表")
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public CommonResult getMessages(@RequestParam(defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "10") Integer pageSize){
        return null;
    }
    @ApiOperation("获取用户统计信息")
    @RequestMapping(value = "/statistic", method = RequestMethod.GET)
    public CommonResult getStatistics(){
        return null;
    }
}
