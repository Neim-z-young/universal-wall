package com.freeLearn.wall.controller;

import com.freeLearn.wall.common.CommonPage;
import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.domain.PostingBrief;
import com.freeLearn.wall.dto.PostingParam;
import com.freeLearn.wall.model.Posting;
import com.freeLearn.wall.model.WallUser;
import com.freeLearn.wall.service.PostingService;
import com.freeLearn.wall.service.WallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userCenter")
public class WallUserCenterController {
    @Autowired
    private PostingService postingService;
    @Autowired
    private WallUserService wallUserService;

    @RequestMapping(value = "/posting", method = RequestMethod.GET)
    CommonResult releasedPostings(@RequestParam(defaultValue = "1") Integer pageNum,
                                  @RequestParam(defaultValue = "10") Integer pageSize){
        WallUser user = wallUserService.getCurrentUser();
        if(user==null){
            return CommonResult.unauthorized("未登录");
        }
        List<PostingBrief> postingBriefList = postingService.listPageByPosterId(user.getId(), pageNum, pageSize);
        if(CollectionUtils.isEmpty(postingBriefList)){
            return CommonResult.failed("未发布任何帖子");
        }
        return CommonResult.success(CommonPage.restPage(postingBriefList));
    }

    @RequestMapping(value = "/posting", method = RequestMethod.DELETE)
    CommonResult deletePosting(@RequestParam Integer postingId){
        WallUser user = wallUserService.getCurrentUser();
        if(user==null){
            return CommonResult.unauthorized("未登录");
        }
        Posting posting = postingService.getById(postingId);
        if(posting==null){
            return CommonResult.failed("并无此帖子");
        }
        if(!posting.getPosterId().equals(user.getId())){
            return CommonResult.unauthorized("不是帖子的所有者");
        }
        return postingService.deletePosting(posting.getId());

    }

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
            return CommonResult.failed("并无此帖子");
        }
        if(!posting.getPosterId().equals(user.getId())){
            return CommonResult.unauthorized("不是帖子的所有者");
        }
        return postingService.updatePosting(posting.getId(), detailedIntroduction, pictureIntroduction);
    }

    @RequestMapping(value = "/posting", method = RequestMethod.POST)
    CommonResult release(@RequestParam PostingParam postingParam){
        WallUser user = wallUserService.getCurrentUser();
        if(user==null){
            return CommonResult.unauthorized("未登录");
        }
        return postingService.addNewPosting(user.getId(), postingParam);
    }
}
