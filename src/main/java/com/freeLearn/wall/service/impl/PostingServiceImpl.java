package com.freeLearn.wall.service.impl;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.dao.PostingBriefDao;
import com.freeLearn.wall.domain.PostingBrief;
import com.freeLearn.wall.domain.PostingDetails;
import com.freeLearn.wall.mapper.PostingMapper;
import com.freeLearn.wall.model.Posting;
import com.freeLearn.wall.service.PostingService;
import com.freeLearn.wall.util.DateUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

public class PostingServiceImpl implements PostingService {
    @Autowired
    private PostingMapper postingMapper;

    @Autowired
    private PostingBriefDao postingBriefDao;

    @Autowired
    private DateUtil dateUtil;

    @Override
    public CommonResult listAll() {
        List<PostingBrief> postingBriefList = postingBriefDao.listAll();
        if(CollectionUtils.isEmpty(postingBriefList)){
            return CommonResult.failed("无可查看的帖子");
        }
        return CommonResult.success(postingBriefList, "帖子查询成功");
    }

    @Override
    public CommonResult listPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PostingBrief> postingBriefList = postingBriefDao.listAll();
        if(CollectionUtils.isEmpty(postingBriefList)){
            return CommonResult.failed("无可查看的帖子");
        }
        return CommonResult.success(postingBriefList, "帖子查询成功");
    }

    @Override
    public CommonResult listLimit(Integer offset, Integer pageSize) {
        PageHelper.offsetPage(offset, pageSize);
        List<PostingBrief> postingBriefList = postingBriefDao.listAll();
        if(CollectionUtils.isEmpty(postingBriefList)){
            return CommonResult.failed("无可查看的帖子");
        }
        return CommonResult.success(postingBriefList, "帖子查询成功");
    }

    @Override
    public CommonResult listAllByCateId(Integer cateId) {
        List<PostingBrief> postingBriefList =  postingBriefDao.listAllByCateId(cateId);
        if(CollectionUtils.isEmpty(postingBriefList)){
            return CommonResult.failed("无可查看的帖子");
        }
        return CommonResult.success(postingBriefList, "帖子查询成功");
    }

    @Override
    public CommonResult listPageByCateId(Integer cateId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PostingBrief> postingBriefList =  postingBriefDao.listAllByCateId(cateId);
        if(CollectionUtils.isEmpty(postingBriefList)){
            return CommonResult.failed("无可查看的帖子");
        }
        return CommonResult.success(postingBriefList, "帖子查询成功");
    }

    @Override
    public CommonResult listLimitByCateId(Integer cateId, Integer offset, Integer pageSize) {
        PageHelper.offsetPage(offset, pageSize);
        List<PostingBrief> postingBriefList =  postingBriefDao.listAllByCateId(cateId);
        if(CollectionUtils.isEmpty(postingBriefList)){
            return CommonResult.failed("无可查看的帖子");
        }
        return CommonResult.success(postingBriefList, "帖子查询成功");
    }

    @Override
    public CommonResult listAllByPosterId(Integer posterId) {
        List<PostingBrief> postingBriefList =  postingBriefDao.listAllByPosterId(posterId);
        if(CollectionUtils.isEmpty(postingBriefList)){
            return CommonResult.failed("无可查看的帖子");
        }
        return CommonResult.success(postingBriefList, "帖子查询成功");
    }

    @Override
    public CommonResult listPageByPosterId(Integer posterId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PostingBrief> postingBriefList =  postingBriefDao.listAllByPosterId(posterId);
        if(CollectionUtils.isEmpty(postingBriefList)){
            return CommonResult.failed("无可查看的帖子");
        }
        return CommonResult.success(postingBriefList, "帖子查询成功");
    }

    @Override
    public CommonResult listLimitByPosterId(Integer posterId, Integer offset, Integer pageSize) {
        PageHelper.offsetPage(offset, pageSize);
        List<PostingBrief> postingBriefList =  postingBriefDao.listAllByPosterId(posterId);
        if(CollectionUtils.isEmpty(postingBriefList)){
            return CommonResult.failed("无可查看的帖子");
        }
        return CommonResult.success(postingBriefList, "帖子查询成功");
    }

    //TODO 二期任务
    @Override
    public CommonResult getById(Integer postingId) {
        return null;
    }

    @Override
    public CommonResult addNewPosting(Integer posterId, String theme, String detailedIntroduction, String pictureIntroduction, Integer cateId) {
        Posting posting = new Posting();
        posting.setPosterId(posterId);
        posting.setTheme(theme);
        posting.setBriefIntroduction(detailedIntroduction.substring(0, 20));
        posting.setDetailedIntroduction(detailedIntroduction);
        posting.setPictureIntroduction(pictureIntroduction);
        posting.setCategoryId(cateId);
        posting.setReleaseTime(dateUtil.getEpochFromDate(new Date()));
        int res = postingMapper.insert(posting);
        if(res>0){
            CommonResult.success(null, "发帖成功");
        }
        return CommonResult.failed("发帖失败");
    }

    @Override
    public CommonResult updatePosting(Integer postingId, String detailedIntroduction, String pictureIntroduction) {
        Posting posting = postingMapper.selectByPrimaryKey(postingId);
        if(posting==null){
            return CommonResult.failed("帖子不存在");
        }
        if(detailedIntroduction!=null){
            posting.setBriefIntroduction(detailedIntroduction.substring(0, 20));
            posting.setDetailedIntroduction(detailedIntroduction);
        }
        posting.setPictureIntroduction(pictureIntroduction);
        int res = postingMapper.updateByPrimaryKeySelective(posting);
        if(res>0){
            return CommonResult.success(null, "修改成功");
        }
        return CommonResult.failed("修改失败");
    }

    @Override
    public CommonResult deletePosting(Integer postingId) {
        int res = postingMapper.deleteByPrimaryKey(postingId);
        if(res>0){
            return CommonResult.success(null, "删除成功");
        }
        return CommonResult.failed("删除失败");
    }
}
