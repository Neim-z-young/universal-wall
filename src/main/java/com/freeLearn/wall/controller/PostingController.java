package com.freeLearn.wall.controller;

import com.freeLearn.wall.common.CommonPage;
import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.domain.PostingBrief;
import com.freeLearn.wall.dto.PostingParam;
import com.freeLearn.wall.service.PostingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "PostingController", description = "帖子管理")
@RestController
@RequestMapping("/posting")
public class PostingController {
    @Autowired
    private PostingService postingService;

    @ApiOperation("按页码列出帖子列表")
    @RequestMapping(value = "/pageNumListPostings",method = RequestMethod.GET)
    CommonResult getPageNumListPostings(@RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "10") Integer pageSize){
        List<PostingBrief> postingBriefList = postingService.listPage(pageNum, pageSize);
        if(CollectionUtils.isEmpty(postingBriefList)){
            return CommonResult.failed("无可查看的帖子");
        }
        return CommonResult.success(CommonPage.restPage(postingBriefList), "帖子查询成功");
    }

    @ApiOperation("按offset列出帖子列表")
    @RequestMapping(value = "/offsetListPostings", method = RequestMethod.GET)
    CommonResult getOffsetListPostings(@RequestParam(defaultValue = "1") Integer offset,
                                        @RequestParam(defaultValue = "10") Integer pageSize){
        List<PostingBrief> postingBriefList = postingService.listLimit(offset, pageSize);
        if(CollectionUtils.isEmpty(postingBriefList)){
            return CommonResult.failed("无可查看的帖子");
        }
        return CommonResult.success(CommonPage.restPage(postingBriefList), "帖子查询成功");
    }

    @ApiOperation("根据类别及页码列出帖子列表")
    @RequestMapping(value = "/pageNumListPostingsByCateId", method = RequestMethod.GET)
    CommonResult getPageNumListPostingsByCateId(@RequestParam Integer cateId,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "10") Integer pageSize){
        List<PostingBrief> postingBriefList = postingService.listPageByCateId(cateId, pageNum, pageSize);
        if(CollectionUtils.isEmpty(postingBriefList)){
            return CommonResult.failed("无可查看的帖子");
        }
        return CommonResult.success(CommonPage.restPage(postingBriefList), "帖子查询成功");
    }
}
